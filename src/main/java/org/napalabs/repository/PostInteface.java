package org.napalabs.repository;

import  org.napalabs.model.Post;

import java.util.List;

public interface PostInteface {
    List<Post> all();
    Post getById(long id);
    Post save(Post post);
    boolean removeById(long id);
}

