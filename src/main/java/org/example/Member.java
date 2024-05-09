package org.example;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.*;  //**
import java.util.Date;

@Entity
@Table(name="MEMBER",
        uniqueConstraints = { //유니크 제약조건 -> 테이블 생성을 JPA를 통해 하지 않는 경우에는 작성하지 않아도 됨
        @UniqueConstraint(
                name = "NAME_AGE_UNIQUE",
                columnNames = {"NAME","AGE"}
        )
        }
)
public class Member {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 생성을 데이터베이스에 위임
    //@GeneratedValue(strategy = GenerationType.SEQUENCE) -> 데이터 베이스 시퀸스를 활용해서 기본키 할당(MYSQL은 제공하지 않아 사용불가)
    private String id;

    @Column(name = "NAME", nullable = false, length = 10) //칼럼 제약조건을 넣을 수 있음
    private String username;

    private Integer age;

    //=== 추가
    @Enumerated(EnumType.STRING) //enum type 이용시
    private RoleType roleType;

    //날짜 타입 이용시
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    //글자 수 무제한 CLOB Type
    @Lob
    private String description;

    @Transient
    private String temp;


    //Getter, Setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
