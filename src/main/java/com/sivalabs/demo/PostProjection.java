package com.sivalabs.demo;

import java.time.LocalDateTime;

public interface PostProjection {
    Long getId();
    String getTitle();
    String getSlug();
    String getContent();
    LocalDateTime getCreatedAt();
}