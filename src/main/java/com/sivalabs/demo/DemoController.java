package com.sivalabs.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {

    private final PostRepository postRepository;

    public DemoController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/api/posts")
    List<Post> getPosts() {
        List<PostProjection> postProjections = postRepository.findAllBy();
        List<Post> posts = new ArrayList<>();
        for (PostProjection postProjection : postProjections) {
            Post post = new Post();
            post.setId(postProjection.getId());
            post.setTitle(postProjection.getTitle());
            post.setCreatedAt(postProjection.getCreatedAt());
            posts.add(post);
        }
        return posts;
    }

    @GetMapping("/api/posts2")
    List<Post> getPosts2() {
        List<PostProjection> postProjections = postRepository.findAllPosts();
        List<Post> posts = new ArrayList<>();
        for (PostProjection postProjection : postProjections) {
            Post post = new Post();
            post.setId(postProjection.getId());
            post.setTitle(postProjection.getTitle());

            //in the following line, postProjection.getCreatedAt() throws exception
            post.setCreatedAt(postProjection.getCreatedAt());
            posts.add(post);
        }
        return posts;
    }

}
