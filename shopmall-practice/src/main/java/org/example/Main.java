package org.example;

/*

요구사항 추가
- 상품을 주문할 때 배송정보를 입력할 수 있으며, 주문과 배송은 일대일 관계
- 상품을 카테고리로 분류 가능

chap07 요구사항 추가
- 상품 종류는 음반,도서,영화가 있고 추후 확장 가능성이 있다.
- 모든 데이터는 등록일과 수정일이 있어야한다.
 */


import org.example.entity.Delivery;
import org.example.entity.Member;
import org.example.entity.Order;
import org.example.entity.OrderItem;

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
            cascadeTest(em);
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


    public static void cascadeTest(EntityManager em){

        Delivery delivery = new Delivery();
//        em.persist(delivery); -> cascade를 이용하여 플러시 시점에 영속성 전이

        OrderItem orderItem1 = new OrderItem();
        OrderItem orderItem2 = new OrderItem();

//        em.persist(orderItem1);
//        em.persist(orderItem2);

        Order order = new Order();
        order.setDelivery(delivery);
        order.addOrderItems(orderItem1);
        order.addOrderItems(orderItem2);


        em.persist(order); //delivery, orderItems플러시 시점에 영속성 전이

    }


}
