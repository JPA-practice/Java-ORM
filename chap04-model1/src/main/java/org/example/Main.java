package org.example;

import org.example.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.Timestamp;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-orm-model");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {

            tx.begin(); //트랜잭션 시작
            saveLogic(em);
            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }


    public static void saveLogic(EntityManager em) {


        Member member = new Member();
        member.setName("지영");

        Order order = new Order();

        em.persist(member);
        em.persist(order);

        order.setMember(member);

        //삭제
//        em.remove(member);
//        em.remove(order);

    }


    public static void logic(EntityManager em, Long orderId){

        Order order = em.find(Order.class, orderId);
        Member member = order.getMember();// 주문회원 참조

        //주문 상품 참조
        OrderItem orderItem = order.getOrderItems().get(0);
        Item item = orderItem.getItem();

    }





}
