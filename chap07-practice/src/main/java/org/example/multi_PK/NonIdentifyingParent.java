package org.example.multi_PK;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/*
비 식별 관계 맵핑 (Non-Identifying Relationship)
부모테이블의 기본키를 받아서 자식 테이블의 외래키로만 사용함

-> 더 많이사용되는 방식

 */

@Entity
@IdClass(NonIdentifyingParentId.class)
public class NonIdentifyingParent {

    @Id
    @Column(name = "PARENT_ID1")
    private String id1;

    @Id
    @Column(name = "PARENT_ID2")
    private String id2;


    private String name;


    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
