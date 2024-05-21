package org.example.entity;


import org.example.entity.item.Item;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private Long id;

    private String name;

    //다대다 관계 (카테고리 - 아이템 : 데이터베이스에서는 다대다관계를 표현할 수 없어 category_item 테이블을 추가로 사용)
    //객체는 다대다관계 표현이 가능하므로, 다음과 같이 테이블을 엮어서 사용
    //카테고리가 관계의 주인이됨 (주인이 누가되든 관계없음)
    //하지만 category_item테이블에 칼럼이추가될 여지가 있고, 그렇게되면 @manytomany가 불가능하므로,
    //실무에서는 유지보수를 위해 연결엔티티(categoryItem)을 만드는것을권장
    @ManyToMany
    @JoinTable(
            name = "CATEGORY_ITEM",
            joinColumns = @JoinColumn(name = "CATEGORY_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
    )
    private List<Item> items = new ArrayList<>();


    //카테고리의 계층구조(포함관계) 구현
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child =  new ArrayList<>();


    public void addChildCategory(Category child){
        this.child.add(child);
        child.setParent(this);
    }

    public void addItem(Item item){
        items.add(item);
    }


    //getter & setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public List<Category> getChild() {
        return child;
    }

    public void setChild(List<Category> child) {
        this.child = child;
    }
}
