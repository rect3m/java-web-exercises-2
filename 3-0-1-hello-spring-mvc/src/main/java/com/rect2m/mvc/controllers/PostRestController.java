package com.rect2m.mvc.controllers;

import com.rect2m.mvc.model.Posts;
import com.rect2m.mvc.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostRestController {

    private final Posts posts;

    /**
     * This method handles GET requests to retrieve all posts.
     *
     * @return a list of posts
     */
    @GetMapping
    public List<Post> getPosts() {
        return posts.getAll();
    }

    /**
     * This method handles POST requests to add a new post.
     *
     * @param post the new post to be added
     * @return ResponseEntity indicating the outcome of the operation
     */
    @PostMapping
    public ResponseEntity<Post> addPost(@RequestBody Post post) {
        posts.add(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }

    /**
     * This method handles GET requests to retrieve a post by ID.
     *
     * @param id the ID of the post to retrieve
     * @return a ResponseEntity containing the requested post or 404 if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable int id) {
        Post post = posts.getById(id);
        if (post != null) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}