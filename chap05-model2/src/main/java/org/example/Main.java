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
            //비즈니스 로직
            testSave(em);
            testFind(em);
            updateRelation(em);


            biDirection(em);

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
        Team team1 = new Team("team1", "팀1");
        em.persist(team1);


        //create member1
        Member member1 = new Member("member1", "회원1");
        member1.setTeam(team1);//reference team -> automatically set fk to the table
        em.persist(member1);

        //create member2
        Member member2 = new Member("member2", "회원2");
        member2.setTeam(team1);//reference  team
        em.persist(member2);


    }


    public static void testFind(EntityManager em){//조회가 영어로 뭐지..

        Member member = em.find(Member.class, "member1");
        Team team = member.getTeam(); //객체 참조!

        System.out.println("팀 이름 = "+ team.getName());
    }


    public static void updateRelation(EntityManager em){

        Team team2 = new Team("team2","팀2");
        em.persist(team2);// jpa 기능을 사용하기 위해서는 persist가 꼭 선행되어야 함

        Member member = em.find(Member.class, "member1");
        member.setTeam(team2); //단순히 set만 진행해도 영속 컨텍스트가 변경을 감지하여 db를 업데이트한다 (em.update 같은 메서드는없음..)

    }


    public static void deleteRelation(EntityManager em){
        Member member1 = em.find(Member.class, "member1");
        member1.setTeam(null);//연관관계 제거 ( 단순히 set으로 해결)

        /*
        db와 마찬가지로 연관 엔티티를 삭게하려면, 연관관계 삭제가 선행되어야 한다.
        ex) team1 제거시 team1에 소속된 모든 member와의 연관관계를 먼저 제거해야함
        member1.setTeam(null)
        member2.setTeam(null)
        em.remove(team1)
         */

    }



    public static void biDirection(EntityManager em){

        Team team = em.find(Team.class, "team1");
        List<Member> members = team.getMembers(); //팀에서 회원을 조회(객체 참조)

        for (Member m: members) {
            System.out.println("member.username = " + m.getUserName());
        }

    }

}
