package org.example.joinTable.oneToOne;

import javax.persistence.*;


/*
테이블구조
Parent - ParentChild(조인테이블이라고 함) - Child

각각의 관계가 1대1관계인 상황
Parent 1 - 1 ParentChild
ParentChild 1 - 1 Child


 */

@Entity
public class Parent {


    @Id
    @GeneratedValue
    @Column(name = "PARENT_ID")
    private Long id;
    private String name;

    @OneToOne
    @JoinTable(//Join Column이 아닌 Join Table 사용
            name = "PARENT_CHILD",//맵핑할 조인 테이블의 이름
            joinColumns = @JoinColumn(name = "PARENT_ID"), //현 클래스를 참조하는 외래키
            inverseJoinColumns = @JoinColumn(name = "CHILD_ID") // 다른쪽 클래스를 참조하는 외래키
    )
    private Child child;


}
