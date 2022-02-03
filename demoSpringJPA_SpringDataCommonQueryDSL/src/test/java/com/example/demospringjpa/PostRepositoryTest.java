package com.example.demospringjpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;

    @Test
    public void crudRepository(){
        // Given
        Post post=new Post();
        post.setTitle("hello spring boot common");

        // When
        Post save = postRepository.save(post);

        // Then
        postRepository.findOne(QPost.post.title.contains("spring"));
        assertTrue(postRepository.contains(save));
    }
}