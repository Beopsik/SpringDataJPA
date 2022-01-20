package com.example.demospringjpa;

import org.checkerframework.checker.units.qual.C;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void crud(){
        // Given
        Comment comment=new Comment();
        comment.setComment("Hello Comment");
        commentRepository.save(comment);

        // When
        List<Comment> all=commentRepository.findAll();

        // Then
        assertThat(all.size()).isEqualTo(1);

        // When
        Optional<Comment> byId = commentRepository.findById(100L);

        // Then
        assertThat(byId).isEmpty();


    }

}