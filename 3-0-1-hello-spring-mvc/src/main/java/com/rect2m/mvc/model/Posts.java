package com.rect2m.mvc.model;

import com.rect2m.mvc.model.Post;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

@Component
public class Posts {
    private final Map<Integer, Post> postsMap = new HashMap<>();
    private int currentId = 1; // Для автоматичної генерації ID

    public List<Post> getAll() {
        var postList = new ArrayList<>(postsMap.values());
        postList.sort(Comparator.comparing(Post::getCreatedOn));
        return postList;
    }

    public void add(Post post) {
        post.setId(currentId++); // Генерація нових ID
        post.setCreatedOn(LocalDateTime.now());
        postsMap.put(post.getId(), post);
    }

    public Post getById(int id) {
        return postsMap.get(id);
    }

    public void update(int id, Post post) {
        if (postsMap.containsKey(id)) {
            post.setId(id);
            post.setCreatedOn(postsMap.get(id).getCreatedOn());
            postsMap.put(id, post);
        }
    }
}

