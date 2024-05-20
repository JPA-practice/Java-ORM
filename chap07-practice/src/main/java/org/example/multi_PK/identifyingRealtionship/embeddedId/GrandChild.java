package org.example.multi_PK.identifyingRealtionship.embeddedId;

import javax.persistence.*;

@Entity
public class GrandChild {


    @EmbeddedId
    private GrandChildId id;

    @MapsId // PK
    @ManyToOne //FK 외래키 맵핑(연관관계 맵핑)
    @JoinColumns(
            {
                    @JoinColumn(name = "PARENT_ID"),
                    @JoinColumn(name = "CHILD_ID"),
            }
    )
    private Child child;


    private String name;


    public GrandChildId getId() {
        return id;
    }

    public void setId(GrandChildId id) {
        this.id = id;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
