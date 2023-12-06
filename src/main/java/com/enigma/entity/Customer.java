package com.enigma.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "m_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "customer_name", length = 50)
    private String name;
    @Column(name = "mobile_phone", length = 20)
    private String phone;
    @Column(name = "is_member")
    private Boolean isMember;
    @OneToMany(mappedBy = "customerId")
    private List<Order> order;

    public Customer(Integer id, String name, String phone, Boolean isMember, List<Order> order) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.isMember = isMember;
        this.order = order;
    }
    public Customer(Integer id, String name, String phone, Boolean isMember) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.isMember = isMember;
    }

    public Customer(String name, String phone, Boolean isMember) {
        this.name = name;
        this.phone = phone;
        this.isMember = isMember;
    }

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getMember() {
        return isMember;
    }

    public void setMember(Boolean member) {
        isMember = member;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", isMember=" + isMember +
                ", order=" + order +
                '}';
    }
}
