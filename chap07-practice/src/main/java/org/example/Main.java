package org.example;

import org.example.multi_PK.NonIdentifyingParent;
import org.example.multi_PK.NonIdentifyingParentId;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-orm-model");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {

            tx.begin(); //트랜잭션 시작
            nonIdentifyingParentSave(em);
            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }


    public static void nonIdentifyingParentSave(EntityManager em) {

        //비식별 클래스
        NonIdentifyingParent nonParent = new NonIdentifyingParent();
        nonParent.setId1("myId1");
        nonParent.setId2("myId2");
        nonParent.setName("NonParentName");

        em.persist(nonParent);

        //복합키를 통한 조회
        NonIdentifyingParentId nonIdentifyingParentId = new NonIdentifyingParentId("myId1","myId2");
        NonIdentifyingParent findNonParent = em.find(NonIdentifyingParent.class, nonIdentifyingParentId);

    }

}