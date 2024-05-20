package org.example.multi_PK;

import java.io.Serializable;

/*
@IdClass의 식별자 클래스

조건
1. 식별자 클래스 속성명과 엔티티에서 사용하는 속성명이 같아야한다 (ParentId.id1 Parent.id1)
2. Serializable인터페이스를 구현해야한다
3. equals, hashCode를 구현해야한다
4. 기본생성자가 필요
5. 식별자 클래스는 public

 */


public class NonIdentifyingParentId implements Serializable {

    private String id1;
    private String id2;

    public NonIdentifyingParentId(){}
    public NonIdentifyingParentId(String id1, String id2){
        this.id1=id1;
        this.id2=id2;
    }

    @Override
    public boolean equals(Object o){
        if(o == this) //자기자신의 참조인지 검사
            return true;
        if(!(o instanceof NonIdentifyingParentId)) //올바른 타입인지 검사
            return false;
        NonIdentifyingParentId pi = (NonIdentifyingParentId) o;// 같은 클래스임이 검증되었으니 형변환
        return pi.id1 == id1 && pi.id2 == id2; //핵심필드의 일치여부 검사
    }


    @Override
    public int hashCode(){
        int result = id1.hashCode();
        result = 31 * result + id2.hashCode();
        return result;
    }

}
