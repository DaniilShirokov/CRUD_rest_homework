package org.napalabs.repository;


import org.napalabs.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostInterface {
    List<Post> all();

    Optional<Post> getById(long id);

    Post save(Post post);

    void removeById(long id);
}
