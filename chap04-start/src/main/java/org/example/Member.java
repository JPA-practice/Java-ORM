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
//@Access(AccessType.FIELD) -> JPA가 필드에 직접 접근한다(@Id를 필드 위에 사용중이면 생략가능)
//@Access((AccessType.PROPERTY) -> JPA가 접근자를 통해 접근한다(@Id를 접근자를 사용중이면 생략가능)
public class Member {

    @Id //JPA가 필드에 직접 접근한다(private이어도) -> @Access
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 생성을 데이터베이스에 위임
    //@GeneratedValue(strategy = GenerationType.SEQUENCE) -> 데이터 베이스 시퀸스를 활용해서 기본키 할당(MYSQL은 제공하지 않아 사용불가)
    private String id;

    @Column(name = "NAME", nullable = false, length = 10, unique = true) //칼럼 제약조건을 넣을 수 있음
    private String username;

    private Integer age;//만약 int와 같은 기본 타입에 @Column을 사용하면 nullable이 true로 세팅되므로 nullable을 false로 세팅하는게 안전!

    //=== 추가
    @Enumerated(EnumType.STRING) //enum type 이용시
    @Column(columnDefinition = "varchar(30) default 'USER'") //default 값 지정 가능
    private RoleType roleType;

    //날짜 타입 이용시
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    /*
    @Temporal
    TemporalType.DATE : 2024-05-11 (DB의 date타입)
    TemporalType.TIME : 11:11:11 (DB의 time타입)
    TemporalTyPE.TIMESTAMP : 2024-05-11 11:11:11 (DB의 timestamp)
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    //글자 수 무제한 CLOB Type
    @Lob
    private String description;

    @Transient //DB와 mapping 하지 않는다, 객체에 임시로 어떤 값을 보관하고 싶을 떄
    private String firstName;

    @Transient
    private String lastName;


    //Getter, Setter

    //@Id -> 필드에 접근자를 이용해 접근한다
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    //username field에 한하여 접근자를 이용해 접근한다 (@Id가 필드에 있더라도)
    @Access(AccessType.PROPERTY)
    public String getUsername() {
        return firstName + lastName;
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

}
