package org.example;

import org.example.multi_PK.NonIdentifyingRealtionship.ParentDB;
import org.example.multi_PK.NonIdentifyingRealtionship.ParentIdDB;
import org.example.multi_PK.NonIdentifyingRealtionship.ParentIdOOP;
import org.example.multi_PK.NonIdentifyingRealtionship.ParentOOP;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        equalsVerify();

//        //엔티티 매니저 팩토리 생성
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-orm-model2");
//        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성
//
//        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
//
//        try {
//
//            tx.begin(); //트랜잭션 시작
//            //nonIdentifyingParentDBSave(em);
//            equalsVerify();
//            tx.commit();//트랜잭션 커밋
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            tx.rollback(); //트랜잭션 롤백
//        } finally {
//            em.close(); //엔티티 매니저 종료
//        }
//
//        emf.close(); //엔티티 매니저 팩토리 종료
    }


    public static void nonIdentifyingParentDBSave(EntityManager em) {

        //비식별 클래스
        ParentDB nonParent = new ParentDB();
        nonParent.setId1("myId1");
        nonParent.setId2("myId2");
        nonParent.setName("NonParentName");

        em.persist(nonParent);

        //복합키를 통한 조회
        ParentIdDB parentIdDB = new ParentIdDB("myId1","myId2");
        ParentDB findNonParent = em.find(ParentDB.class, parentIdDB);

    }


    public static void nonIdentifyingParentOOPSave(EntityManager em) {

        //비식별 클래스
        ParentOOP nonParent = new ParentOOP();
        ParentIdOOP parentIdOOP = new ParentIdOOP("myId1","myId2");
        nonParent.setId(parentIdOOP);
        nonParent.setName("NonParentName");

        em.persist(nonParent);

        ParentIdOOP findParentIdOOP = new ParentIdOOP("myId1","myId2");
        ParentOOP parentOOP = em.find(ParentOOP.class, findParentIdOOP);
    }


    public static void equalsVerify(){


        ParentIdDB id1 = new ParentIdDB();

        id1.setId1("myId1");
        id1.setId2("myId2");


        ParentIdDB id2 = new ParentIdDB();

        id2.setId1("myId1");
        id2.setId2("myId2");


        System.out.println(id1.equals(id2));
        //id1,id2는 다른 객체지만 equals는 논리적의미의 동일성을 판단하므로, pk가 같은 두 객체는 참이나와야 맞다 -> equals를 제대로 오버라이딩한 경우에는 참이 나올것

    }

}