package org.example;

import org.example.entity.Member;
import org.example.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-orm-model2");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {


            tx.begin(); //트랜잭션 시작
            testSave(em);  //비즈니스 로직
            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }


    public static void testSave(EntityManager em){

        //create team1
        Team team2 = new Team("team2", "팀2");
        em.persist(team2);


        //create member1
        Member member1 = new Member("member1", "회원1");
        member1.setTeam(team2);//reference team
        em.persist(member1);

        //create member2
        Member member2 = new Member("member2", "회원2");
        member2.setTeam(team2);//reference  team
        em.persist(member2);


    }



}
