package org.example.multi_PK.NonIdentifyingRealtionship;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ParentOOP {

    @EmbeddedId //객체지향에 맞는 방식 -> 객체지향적이고 중복이 없다 , 상황에 따라 JPQL이 더 길어질수 있다 (parentOOP.id.id1 <-이렇게 접근해야함)
    private ParentIdOOP id;

    private String name;


    public ParentIdOOP getId() {
        return id;
    }

    public void setId(ParentIdOOP id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
