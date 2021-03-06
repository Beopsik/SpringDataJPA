package com.example.demospringjpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.NamedQuery;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTitleStartsWith(String title);

    @Query("select p from Post as p where p.title = ?1")
    List<Post> findByTitle(String title, Sort sort);
}
