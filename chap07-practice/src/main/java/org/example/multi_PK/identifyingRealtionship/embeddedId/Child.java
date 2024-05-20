package org.example.multi_PK.identifyingRealtionship.embeddedId;


import javax.persistence.*;

@Entity
public class Child {

    @EmbeddedId
    private ChildId id;


    @MapsId("parentId") //ChildId.parentId mapping
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    public Parent parent;


    private String name;


    public ChildId getId() {
        return id;
    }

    public void setId(ChildId id) {
        this.id = id;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
