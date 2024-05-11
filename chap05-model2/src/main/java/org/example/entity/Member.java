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

    //연관관계 설정( 양방향으로 관계를 설정하면 신경써 줄것이 많다..) 
    public void setTeam(Team team){

        //주의! 기존팀과의 관계를 삭제하지 않으면, team.members에는 여전히 멤버가 남아있게된다!
        //변경시에는 기존 관계를 삭제해주어야 한다.
        if(this.team != null){
            this.team.getMembers().remove(this);
        }

        this.team = team;
        team.getMembers().add(this); //양방향 관계인경우 객체 관점에서는 양방향으로 추가해주는게 맞다
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
