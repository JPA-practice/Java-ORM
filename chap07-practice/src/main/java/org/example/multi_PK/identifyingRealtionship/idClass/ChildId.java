package org.example.multi_PK.identifyingRealtionship.idClass;

import org.example.multi_PK.NonIdentifyingRealtionship.ParentIdDB;

import java.io.Serializable;

//Child 클래스는 pk가 2개이므로 복합키 클래스필요
public class ChildId implements Serializable {

    private String parent;//Child.parent
    private String childId;//Child.childId

    public boolean equals(Object o){
        if(o == this) //자기자신의 참조인지 검사
            return true;
        if(!(o instanceof ChildId)) //올바른 타입인지 검사
            return false;
        ChildId ci = (ChildId) o;// 같은 클래스임이 검증되었으니 형변환

        //pk의 값이 같아야함
        return ci.parent.equals(parent) && ci.childId.equals(childId); //핵심필드의 일치여부 검사
    }


    @Override
    public int hashCode(){
        int result = parent.hashCode();
        result = 31 * result + childId.hashCode();
        return result;
    }


    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getChildId() {
        return childId;
    }

    public void setChildId(String childId) {
        this.childId = childId;
    }
}
