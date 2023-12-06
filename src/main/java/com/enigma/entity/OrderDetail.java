package com.enigma.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "t_order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order orderId;
    @ManyToOne
    @JoinColumn(name = "menu_price_id")
    private MenuPrice menuPriceId;
    private Integer qty;

    public OrderDetail(Integer id, Order orderId, MenuPrice menuPriceId, Integer qty) {
        this.id = id;
        this.orderId = orderId;
        this.menuPriceId = menuPriceId;
        this.qty = qty;
    }

    public OrderDetail(Order orderId, MenuPrice menuPriceId, Integer qty) {
        this.orderId = orderId;
        this.menuPriceId = menuPriceId;
        this.qty = qty;
    }

    public OrderDetail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }

    public MenuPrice getMenuPriceId() {
        return menuPriceId;
    }

    public void setMenuPriceId(MenuPrice menuPriceId) {
        this.menuPriceId = menuPriceId;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", menuPriceId=" + menuPriceId +
                ", qty=" + qty +
                '}';
    }
}
