package com.jojolud.admin.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepositoty extends JpaRepository<Posts, Long> {
}
