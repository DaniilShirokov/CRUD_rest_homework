package org.napalabs.repository;

import org.napalabs.model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements PostInterface {
    private final Map<Long, Post> postMap = new ConcurrentHashMap<>();
    long count = 1;

    public List<Post> all() {
        return new ArrayList<>(postMap.values());
    }

    public Optional<Post> getById(long id) {
        Post post = postMap.get(id);
        return Optional.ofNullable(post);
    }

    public Post save(Post post) {
        if (post.getId() == 0) {
            var newID = count;
            count++;
            post.setId(newID);
            return postMap.put(newID, post);
        } else {
            return postMap.replace(post.getId(),post);
        }
    }

    public void removeById(long id) {
        var item = postMap.get(id);
        if (item != null) {
            postMap.remove(id);

        }
        System.out.println("Can't delete element, not found");
    }
}
