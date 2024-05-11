package org.example.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @Column(name = "TEAM_ID")
    private String id;

    private String name;

    //team에게는 member가 여러명이므로 list ( one to many)
    @OneToMany(mappedBy = "team")//양방향 맵핑일 때 사용하며, 반대쪽 매핑의 필드값을 주면됨
    //mappedBy : 연관관계의 주인을 명시함(본인이 주인이 아니기때문)
    //읽기만 하고 변경은 불가능하다
    private List<Member> members = new ArrayList<>();

    public Team(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Team() {

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
