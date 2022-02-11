package com.example.demospringjpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.NamedQuery;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTitleStartsWith(String title);

    @Query("select p from #{#entityName} as p where p.title = :title")
    List<Post> findByTitle(@Param("title") String title, Sort sort);
}
