package org.example.multi_PK.identifyingRealtionship.embeddedId;

import javax.persistence.Column;
import java.io.Serializable;


public class GrandChildId implements Serializable {

    private ChildId childId;

    @Column(name = "GRANDCHILD_ID")
    private String id;


    public boolean equals(Object o){
        if(o == this) //자기자신의 참조인지 검사
            return true;
        if(!(o instanceof GrandChildId)) //올바른 타입인지 검사
            return false;
        GrandChildId ci = (GrandChildId) o;// 같은 클래스임이 검증되었으니 형변환

        //child는 childId에서 구현된 equals를 사용해서 안전
        return ci.childId.equals(childId) && ci.id.equals(id); //핵심필드의 일치여부 검사
    }


    @Override
    public int hashCode(){
        int result = childId.hashCode(); //child는 childId에서 구현된 hashCode를 사용해서 안전
        result = 31 * result + id.hashCode();
        return result;
    }

}
