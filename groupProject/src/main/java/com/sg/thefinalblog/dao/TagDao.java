/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.thefinalblog.dao;

import com.sg.thefinalblog.dto.Tag;
import java.util.List;

/**
 *
 * @author abdiriman
 */
public interface TagDao {

    public Tag getTagById(int id);

    public Tag addTag(Tag tag);

    public List<Tag> getAllTags();

    public void updateTag(Tag tag);

    public void deleteTag(int id);
    
    public List<Tag> getAllTagsByPostId(int postId);

}
