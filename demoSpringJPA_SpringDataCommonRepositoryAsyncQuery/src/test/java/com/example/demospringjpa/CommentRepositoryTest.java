package com.example.demospringjpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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
        Future<List<Comment>> future=commentRepository.findByCommentContainsIgnoreCase("comment");

        // Then
        System.out.println("==================");
        System.out.println("is done?"+future.isDone());

        try {
            List<Comment> comments = future.get();
            comments.forEach(System.out::println);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

}