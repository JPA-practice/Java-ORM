package org.example.multi_PK.identifyingRealtionship.oneToOne;

import javax.persistence.*;

//부모
@Entity
public class Board {


    @Id
    @GeneratedValue
    @Column(name = "BOARD_ID")
    private Long id;


    private String title;


    @OneToOne(mappedBy = "board")
    private BoardDetail boardDetail;
}
