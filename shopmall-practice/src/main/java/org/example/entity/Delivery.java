package org.example.entity;


import org.example.entity.valueType.Address;

import javax.persistence.*;

@Entity
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;


    @Embedded
    private Address address; //공통되는 내역들을 임베디드 값 타입으로 묶어서 객체지향 적으로
//    private String city;
//    private String street;
//    private String zipcode;


    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;


    //getter & setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }
}
