/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.thefinalblog.dao;

import com.sg.thefinalblog.dto.Post;
import com.sg.thefinalblog.dto.Tag;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author heath
 */
public class TagDaoDbImpl implements TagDao {

    @Inject
    JdbcTemplate jdbc;

    private static final String SELECT_TAG_BY_ID = "select * from tag where id = ?";

    @Override
    public Tag getTagById(int id) {
        try {
            return jdbc.queryForObject(SELECT_TAG_BY_ID, new TagMapper(), id);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    private static final String INSERT_TAG = "INSERT INTO tag(name) VALUES(?)";

    @Override
    public Tag addTag(Tag tag) {
        jdbc.update(INSERT_TAG, tag.getName());

        int id = jdbc.queryForObject("select LAST_INSERT_ID()", Integer.class);
        tag.setId(id);

        return tag;

    }

    private static final String GET_ALL_TAGS = "select * from tag";

    @Override
    public List<Tag> getAllTags() {
        return jdbc.query(GET_ALL_TAGS, new TagMapper());
    }

    private static final String UPDATE_TAG = "UPDATE tag SET name = ? WHERE id = ?";

    @Override
    public void updateTag(Tag tag) {
        jdbc.update(UPDATE_TAG, tag.getName(), tag.getId());
    }

    //DELETE
    private static final String DELETE_TAG
            = "DELETE FROM tag WHERE id = ?";
    private static final String DELETE_POST_TAG
            = "DELETE FROM postTag where tagId = ?";

    @Override
    @Transactional
    public void deleteTag(int id) {
        jdbc.update(DELETE_POST_TAG, id);
        jdbc.update(DELETE_TAG, id);
    }

    private static final String SELECT_TAGS_BY_POST_ID
            = "select * from tag ta join posttag pota on ta.id = pota.tagid "
            + "where post.id = ?";

    private List<Tag> findTagsforPost(Post post) {
        return jdbc.query(SELECT_TAGS_BY_POST_ID,
                new TagMapper(), post.getTags());
    }

    //GET ALL TAGS BY POST ID
    private static String SELECT_ALL_TAGS_BY_POST_ID
            = "select t.* from tag t "
            + "join posttag pt on t.id = pt.tagId "
            + "join post p on pt.postId = p.id "
            + "where p.id = ?";
    @Override
    public List<Tag> getAllTagsByPostId(int postId) {
        List<Tag> tags = jdbc.query(SELECT_ALL_TAGS_BY_POST_ID, 
                new TagMapper(), postId);
        return tags;
    }

    public static final class TagMapper implements RowMapper<Tag> {

        @Override
        public Tag mapRow(ResultSet rs, int i) throws SQLException {
            Tag t = new Tag();
            t.setId(rs.getInt("id"));
            t.setName(rs.getString("name"));
            return t;
        }
    }

}
