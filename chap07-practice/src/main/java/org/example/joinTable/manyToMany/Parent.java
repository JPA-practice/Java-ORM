package org.example.joinTable.manyToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/*
테이블구조
Parent - ParentChild(조인테이블이라고 함) - Child


Parent 1 - 다 ParentChild
ParentChild 1 - 다 Child


 */

@Entity
public class Parent {


    @Id
    @GeneratedValue
    @Column(name = "PARENT_ID")
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "PARENT_CHILD",
            joinColumns = @JoinColumn(name = "PARENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "CHILD_ID")
    )
    private List<Child> child = new ArrayList<>();


}
