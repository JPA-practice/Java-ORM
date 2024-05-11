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

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
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
