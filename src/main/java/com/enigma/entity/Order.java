package com.enigma.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "trans_date")
    private Date transDate;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customerId;
    @OneToMany(mappedBy = "orderId")
    private List<OrderDetail> orderDetail;

    public Order(Date transDate, Customer customerId) {
        this.transDate = transDate;
        this.customerId = customerId;
    }

    public Order(Integer id, Date transDate, Customer customerId, List<OrderDetail> orderDetail) {
        this.id = id;
        this.transDate = transDate;
        this.customerId = customerId;
        this.orderDetail = orderDetail;
    }

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public List<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", transDate=" + transDate +
                ", orderDetail=" + orderDetail +
                '}';
    }
}
