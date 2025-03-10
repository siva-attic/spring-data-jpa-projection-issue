package com.sivalabs.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<PostProjection> findAllBy();

    @Query("from Post")
    List<PostProjection> findAllPosts();
}