package org.example.multi_PK.identifyingRealtionship.embeddedId;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ChildId implements Serializable {

    private String parentId;//@MapsId("parentId")를 통해 맵핑됨

    @Column(name = "CHILD_ID")
    private String id;//Child.childId

    public boolean equals(Object o){
        if(o == this) //자기자신의 참조인지 검사
            return true;
        if(!(o instanceof ChildId)) //올바른 타입인지 검사
            return false;
        ChildId ci = (ChildId) o;// 같은 클래스임이 검증되었으니 형변환

        //pk의 값이 같아야함
        return ci.parentId.equals(parentId) && ci.id.equals(id); //핵심필드의 일치여부 검사
    }


    @Override
    public int hashCode(){
        int result = parentId.hashCode();
        result = 31 * result + id.hashCode();
        return result;
    }



}
