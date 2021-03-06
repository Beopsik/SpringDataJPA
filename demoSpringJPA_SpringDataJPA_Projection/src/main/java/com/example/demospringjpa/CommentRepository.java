package com.example.demospringjpa;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @EntityGraph(attributePaths = "post")
    Optional<Comment> getCommentById(Long id);

    List<CommentSummary> findByPost_Id(Long id);
}
