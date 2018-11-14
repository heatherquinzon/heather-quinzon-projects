/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.thefinalblog.dao;

import com.sg.thefinalblog.dto.Post;
import com.sg.thefinalblog.dto.Tag;
import java.util.List;

/**
 *
 * @author heath
 */
public interface PostDao {

    public Post getPostById(int Id);

    public List<Post> getAllPosts();

    public Post addPost(Post post);

    public void updatePost(Post Post);

    public void deletePost(int id);

    public List<Post> getAllPostsByTagId(int tagId);
    
    public List<Post> getAllPostsByCategoryId(int categoryId);
}
