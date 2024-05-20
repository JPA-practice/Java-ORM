package org.example.multi_PK.identifyingRealtionship.oneToOne;


import javax.persistence.*;

//자식
@Entity
public class BoardDetail {//Board와 1대1관계, Board의 자식


    @Id
    private Long boardId; //pk값으로 부모의 pk를 사용함 (1개 이므로 복합 키로 구성하지는 않아도 된다)


    @MapsId //BoardDetail.boardId와 맵핑 -> board의 pk값을 사용 (1개 일때는 name 생략가능)
    @OneToOne //board와의 1대1관계를 맵핑
    @JoinColumn(name = "BOARD_ID")
    private Board board;



    private String content;

}
