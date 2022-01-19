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
        Account account=new Account();
        account.setUsername("beobsik");
        account.setPassword("hibernate");

        Study study=new Study();
        study.setName("Spring Data JPA");
        study.setOwner(account);
        //entityManager.persist(account); // JPA 엔티티 매니저로 저장

        Session session=entityManager.unwrap(Session.class);
        session.save(account); // 하이버네이트 세션으로 저장
        session.save(study);
    }
}
