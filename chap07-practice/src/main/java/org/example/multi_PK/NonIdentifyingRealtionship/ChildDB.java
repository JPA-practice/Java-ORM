package org.example.multi_PK.NonIdentifyingRealtionship;


import javax.persistence.*;

@Entity
public class ChildDB {

    @Id
    private String id;


    @ManyToOne
    @JoinColumns(//FK도 복합키이다
            {
                    @JoinColumn(name = "PARENT_ID1", referencedColumnName = "PARENT_ID1"),
                    @JoinColumn(name = "PARENT_ID2", referencedColumnName = "PARENT_ID2")
            }
    )
    private ParentDB parentDB;


}
