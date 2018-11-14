/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.thefinalblog.dao;

import com.sg.thefinalblog.dao.CategoryDaoDbImpl.CategoryMapper;
import com.sg.thefinalblog.dao.RoleDaoDbImpl.RoleMapper;
import com.sg.thefinalblog.dao.TagDaoDbImpl.TagMapper;
import com.sg.thefinalblog.dao.UserDaoDbImpl.UserMapper;
import com.sg.thefinalblog.dto.Category;
import com.sg.thefinalblog.dto.Post;
import com.sg.thefinalblog.dto.Role;
import com.sg.thefinalblog.dto.Tag;
import com.sg.thefinalblog.dto.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author abdiriman
 */
public class PostDBImpl implements PostDao {

    @Inject
    JdbcTemplate jdbc;

    private static final String GET_POST_BY_ID = "select * from post where id = ?";

    @Override
    public Post getPostById(int postId) {
        try {
            Post post = jdbc.queryForObject(GET_POST_BY_ID, new PostMapper(), postId);
            post.setCategory(getCategoryByPostId(postId));
            User u = getUserByPostId(postId);
            u.setRoles(getRolesForUserByUserId(u.getId()));
            post.setUser(u);
            post.setTags(getTagsByPostId(post.getId()));
            Post rp = getReferencedPostByPostId(post.getId());
            if (rp != null) {
                rp.setCategory(getCategoryByPostId(rp.getId()));
                User ru = getUserByPostId(rp.getId());
                ru.setRoles(getRolesForUserByUserId(ru.getId()));
                rp.setUser(ru);
                rp.setTags(getTagsByPostId(rp.getId()));
            }
            post.setReferencedPost(rp);
            return post;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    private static final String GET_ALL_POSTS = "select * from post "
            + "order by postDate desc";

    @Override
    public List<Post> getAllPosts() {
        List<Post> posts = jdbc.query(GET_ALL_POSTS, new PostMapper());
        populatePosts(posts);
        return posts;
    }

    private void populatePosts(List<Post> posts) {
        for (Post p : posts) {
            p.setCategory(getCategoryByPostId(p.getId()));
            p.setTags(getTagsByPostId(p.getId()));
            User u = getUserByPostId(p.getId());
            u.setRoles(getRolesForUserByUserId(u.getId()));
            p.setUser(u);
            Post rp = getReferencedPostByPostId(p.getId());
            if (rp != null) {
                rp.setCategory(getCategoryByPostId(rp.getId()));
                User ru = getUserByPostId(rp.getId());
                ru.setRoles(getRolesForUserByUserId(ru.getId()));
                rp.setUser(ru);
                rp.setTags(getTagsByPostId(rp.getId()));
            }
            p.setReferencedPost(rp);
        }
    }
    private static final String INSERT_POST
            = "INSERT INTO post(title, postDate, content, userId, state, referencingId, categoryId) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?)";
    private static final String INSERT_POST_TAG = "INSERT INTO PostTag(postId, tagId) VALUES(?, ?)";

    @Override
    public Post addPost(Post post) {
        jdbc.update(INSERT_POST,
                post.getTitle(),
                post.getDate(),
                post.getContent(),
                post.getUser().getId(),
                post.getState(),
                (post.getPost() == null) ? null : post.getPost().getId(),
                (post.getCategory() == null) ? null : post.getCategory().getId());

        int id = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        post.setId(id);

        addPostTag(post);
        return post;
    }

    public void addPostTag(Post post) {
        for (Tag t : post.getTags()) {
            jdbc.update(INSERT_POST_TAG, post.getId(),
                    t.getId());
        }
    }

    private static final String UPDATE_POST
            = "UPDATE post SET "
            + "title = ?, postDate = ?, content = ?, userId = ?, state = ?, "
            + "referencingId = ?, categoryId = ? "
            + "WHERE id = ?";

    private static final String DELETE_POST_TAG
            = "DELETE FROM postTag "
            + "WHERE postId = ?";

    @Override
    @Transactional
    public void updatePost(Post post) {
        jdbc.update(UPDATE_POST,
                post.getTitle(),
                post.getDate(),
                post.getContent(),
                post.getUser().getId(),
                post.getState(),
                (post.getPost() == null) ? null : post.getPost().getId(),
                (post.getCategory() == null) ? null : post.getCategory().getId(),
                post.getId());

        jdbc.update(DELETE_POST_TAG,
                post.getId());

        addPostTag(post);
    }

    //REMOVE
    private static final String DELETE_POST
            = "DELETE FROM post where id = ?";

    private static final String DELETE_REFERENCED_POST
            = "DELETE FROM post "
            + "WHERE referencingId = ?";

    private static final String DELETE_REPLY_POST_TAG
            = "DELETE pt FROM postTag pt "
            + "JOIN post p "
            + "ON pt.postId = p.id "
            + "WHERE referencingId = ?";

    @Override
    public void deletePost(int id) {
        jdbc.update(DELETE_REPLY_POST_TAG, id);
        jdbc.update(DELETE_REFERENCED_POST, id);
        jdbc.update(DELETE_POST_TAG, id);
        jdbc.update(DELETE_POST, id);
    }

    private static final String SELECT_POSTS_BY_TAG_ID
            = "SELECT p.* FROM post p "
            + "JOIN postTag pt "
            + "ON p.id = pt.postId "
            + "WHERE pt.tagId = ?";

    @Override
    public List<Post> getAllPostsByTagId(int tagId) {
        List<Post> posts = jdbc.query(SELECT_POSTS_BY_TAG_ID, new PostMapper(), tagId);
        populatePosts(posts);
        return posts;
    }

    private static final String SELECT_POSTS_BY_CATEGORY_ID
            = "SELECT * FROM post "
            + "WHERE categoryId = ?";

    @Override
    public List<Post> getAllPostsByCategoryId(int categoryId) {
        List<Post> posts = jdbc.query(SELECT_POSTS_BY_CATEGORY_ID, 
                new PostMapper(), categoryId);
        populatePosts(posts);
        return posts;
    }

    public static final class PostMapper implements RowMapper<Post> {

        @Override
        public Post mapRow(ResultSet rs, int i) throws SQLException {
            Post p = new Post();
            p.setId(rs.getInt("id"));
            p.setTitle(rs.getString("title"));
            p.setDate(rs.getDate("postDate").toLocalDate());
            p.setContent(rs.getString("content"));
            p.setState(rs.getInt("state"));
            return p;
        }
    }
//
//    private void insertPostTag(Post post) {
//        final int postId = post.getId();
//        final List<Tag> tags = post.getTags();
//
//        for (Tag currentTag : tags) {
//            jdbc.update(INSERT_POST_TAG,
//                    postId, currentTag.getId());
//        }
//    }

    private static final String SELECT_CATEGORY_BY_POST_ID
            = "SELECT c.* FROM post p "
            + "JOIN category c "
            + "ON c.id = p.categoryId "
            + "WHERE p.id = ?";

    private Category getCategoryByPostId(int postId) {
        try {
            return jdbc.queryForObject(SELECT_CATEGORY_BY_POST_ID, new CategoryMapper(), postId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    private static final String SELECT_REFERENCED_POST_BY_POST_ID
            = "SELECT p2.* "
            + "FROM post p "
            + "JOIN post p2 "
            + "ON p2.id = p.referencingId "
            + "WHERE p.id = ?";

    private Post getReferencedPostByPostId(int postId) {
        try {
            return jdbc.queryForObject(SELECT_REFERENCED_POST_BY_POST_ID, new PostMapper(), postId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    private static final String SELECT_TAGS_BY_POST_ID
            = "SELECT t.* "
            + "FROM tag t "
            + "JOIN postTag pt "
            + "ON t.id = pt.tagId "
            + "WHERE pt.postId = ?";

    private List<Tag> getTagsByPostId(int postId) {
        return jdbc.query(SELECT_TAGS_BY_POST_ID, new TagMapper(), postId);
    }

    private static final String SELECT_USER_BY_POST_ID
            = "SELECT u.* "
            + "FROM users u "
            + "JOIN post p "
            + "ON u.id = p.userId "
            + "WHERE p.id = ?";

    private User getUserByPostId(int postId) {
        try {
            return jdbc.queryForObject(SELECT_USER_BY_POST_ID, new UserMapper(), postId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
    private static final String SELECT_ROLES_FOR_USER_BY_USER_ID
            = "SELECT r.* "
            + "FROM role r "
            + "JOIN usersRole ur "
            + "ON r.id = ur.roleId "
            + "WHERE ur.usersId = ?";

    private Set<Role> getRolesForUserByUserId(int userId) {
        List<Role> roles = jdbc.query(SELECT_ROLES_FOR_USER_BY_USER_ID, new RoleMapper(), userId);
        Set<Role> roleSet = new HashSet<>(roles);
        return roleSet;
    }
}
