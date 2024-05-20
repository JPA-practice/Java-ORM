package org.example.multi_PK.NonIdentifyingRealtionship;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/*
@EmbeddedId의 식별자 클래스

조건
1. @Embeddable 어노테이션 필수
2. Serializable인터페이스를 구현해야한다
3. equals, hashCode를 구현해야한다
4. 기본생성자가 필요
5. 식별자 클래스는 public

 */

@Embeddable
public class ParentIdOOP implements Serializable {

    @Column(name = "PARENT_OOP_ID1")
    private String id1;

    @Column(name = "PARENT_OOP_ID2")
    private String id2;


    public ParentIdOOP() {
    }



    public ParentIdOOP(String id1, String id2) {
        this.id1 = id1;
        this.id2 = id2;
    }

    @Override
    public boolean equals(Object o){
        if(o == this) //자기자신의 참조인지 검사
            return true;
        if(!(o instanceof ParentIdOOP)) //올바른 타입인지 검사
            return false;
        ParentIdOOP pi = (ParentIdOOP) o;// 같은 클래스임이 검증되었으니 형변환
        return pi.id1 == id1 && pi.id2 == id2; //핵심필드의 일치여부 검사
    }


    @Override
    public int hashCode(){
        int result = id1.hashCode();
        result = 31 * result + id2.hashCode();
        return result;
    }
}
