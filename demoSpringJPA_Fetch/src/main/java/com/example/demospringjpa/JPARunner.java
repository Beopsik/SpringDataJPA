package com.example.demospringjpa;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class JPARunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Post post=new Post();
//        post.setTitle("Spring Data JPA 언제 보나,,,");
//
//        Comment comment1=new Comment();
//        comment1.setComment("빨리 보고싶어요.");
//        post.addComment(comment1);
//
//        Comment comment2=new Comment();
//        comment2.setComment("곧 보여드릴게요.");
//        post.addComment(comment2);

        Session session=entityManager.unwrap(Session.class);
//        session.save(post);

//        Post getPost=session.get(Post.class, 1L);
//        System.out.println("=============================================");
//        System.out.println(getPost.getTitle());

        Comment getComment=session.get(Comment.class, 2L);
        System.out.println("=============================================");
        System.out.println(getComment.getComment());
        System.out.println(getComment.getPost().getTitle());



    }
}
