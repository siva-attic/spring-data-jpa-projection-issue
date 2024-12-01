package com.sivalabs.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringDataJpaProjectionIssueApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaProjectionIssueApplication.class, args);
    }

    @Bean
    ApplicationRunner init(PostRepository postRepository) {
        return args -> {
            Post post1 = new Post("post1", "post-1", "this is post 1");
            Post post2 = new Post("post2", "post-2", "this is post 2");
            postRepository.save(post1);
            postRepository.save(post2);

            List<PostProjection> posts = postRepository.findAllBy();
            for (PostProjection post : posts) {
                //org.springframework.data.jpa.repository.query.AbstractJpaQuery$TupleConverter$TupleBackedMap@301b89e1
                System.out.println(post.getId() + " " + post.getCreatedAt());
            }
            System.out.println("============1================");
            List<PostProjection> posts2 = postRepository.findAllPosts();
            for (PostProjection post : posts2) {
                //Proxy of com.sivalabs.demo.Post@65c634f2
                System.out.println(post.getId() + " " + post.getCreatedAt());
            }
            System.out.println("============2================");
        };
    }

}
