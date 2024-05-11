package org.example;

import org.example.entity.Member;
import org.example.entity.Order;
import org.example.entity.OrderStatus;

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
            logic(em);
            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }


    public static void logic(EntityManager em) {


        Member member = new Member();
        member.setName("Jason");

        //등록
        em.persist(member);


        Order order = new Order();
        order.setMemberId(member.getId());
        order.setStatus(OrderStatus.ORDER);

        em.persist(order);


        //외래 키로 다시 조회하는 방법(외래키를 조회함) -> 객체지향이 아님
        Order findOrder = em.find(Order.class, order.getId());
        Member findMember = em.find(Member.class, findOrder.getMemberId());

        System.out.println("==================================");
        System.out.println(findMember.getName());
        System.out.println("==================================");
        //객체지향 적인 방법 (객체를 참조함)
//        Order newOrder = em.find(Order.class, order.getId());
//        Member newMember = newOrder.getMember();


        //삭제
        em.remove(member);
        em.remove(order);

    }

}
