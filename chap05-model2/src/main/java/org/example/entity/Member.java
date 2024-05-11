package org.example.entity;

import javax.persistence.*;

/*

-  회원은 하나의 팀에만 소속될 수 있다
-  회원과 팀은 다대일 관계이다

 */


@Entity
public class Member {

    @Id
    @Column(name = "MEMBER_ID")
    private String id;

    private String userName;

    @ManyToOne//테이블 관계에서 ManyToOne은 항상 연관관계의 주인이다
    @JoinColumn(name = "TEAM_ID") //member 는 team 외래키의 주인! (멤버 테이블에 fk가 존재함)
    //외래키의 주인이므로 읽기 + 수정,쓰기가 가능하다
    //(member는 team을 변경가능하지만, team은 member를 변경불가)
    private Team team;


    //team은 연관관계 설정시에 넣도록
    public Member(String id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public Member() {

    }

    //연관관계 설정
    public void setTeam(Team team){
        this.team = team;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Team getTeam() {
        return team;
    }
}
