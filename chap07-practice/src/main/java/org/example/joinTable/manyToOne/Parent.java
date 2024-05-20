package org.example.joinTable.manyToOne;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/*
테이블구조
Parent - ParentChild(조인테이블이라고 함) - Child


Parent 1 - 다 ParentChild
ParentChild 1 - 1 Child


 */

@Entity
public class Parent {


    @Id
    @GeneratedValue
    @Column(name = "PARENT_ID")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "parent")
    private List<Child> child = new ArrayList<>();


}
