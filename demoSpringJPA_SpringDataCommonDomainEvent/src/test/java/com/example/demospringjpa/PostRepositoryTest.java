package com.example.demospringjpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(PostRepositoryTestConfig.class)
public class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;

//    @Autowired
//    ApplicationContext applicationContext;
//
//    @Test
//    public void event(){
//        Post post=new Post();
//        post.setTitle("hello spring event");
//        PostPublishedEvent event=new PostPublishedEvent(post);
//
//        applicationContext.publishEvent(event);
//    }
    @Test
    public void crudRepository(){
        // Given
        Post post=new Post();
        post.setTitle("hello spring boot common");
        assertThat(postRepository.contains(post)).isFalse();

        // When
        postRepository.save(post.publish());

        // Then
        assertThat(postRepository.contains(post)).isTrue();

        postRepository.delete(post);
        postRepository.flush();
    }
}