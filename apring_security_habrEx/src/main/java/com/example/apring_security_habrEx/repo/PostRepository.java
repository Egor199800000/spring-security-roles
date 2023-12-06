package com.example.apring_security_habrEx.repo;

import com.example.apring_security_habrEx.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
