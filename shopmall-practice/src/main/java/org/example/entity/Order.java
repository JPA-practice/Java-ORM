package org.example.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="ORDERS")
public class Order extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) //xtoOne의 경우 디폴트가 즉시로딩이므로, 지연로딩으로 변경
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();


    //일대일관계 -> 어느쪽에서 fk,관계의 주인이 되던지 상관없지만
    //로직상 주문에서 배송에 접근할 일이 많으므로 ORDERS가 관계의 주인이됨
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;


    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;



    public void setMember(Member member) {
        //새로추가하기 전 기존 연결관계를 제거해줌
        if(this.member != null){
            this.member.getOrders().remove(this);
        }

        //양방향으로 추가
        this.member = member;
        member.getOrders().add(this);
    }


    public void addOrderItems(OrderItem orderItem) {
        //양방향으로 추가
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }


    public void setDelivery(Delivery delivery) {
        //양방향으로 추가
        this.delivery = delivery;
        delivery.setOrder(this);
    }


    //getter & setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }


    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
