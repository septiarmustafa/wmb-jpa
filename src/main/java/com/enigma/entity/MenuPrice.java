package com.enigma.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "m_menu_price")
public class MenuPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menuId;

    @OneToMany(mappedBy = "menuPriceId")
    private List<OrderDetail> orderDetail;

    private Integer price;

    public MenuPrice(Integer id, Menu menuId, List<OrderDetail> orderDetail, Integer price) {
        this.id = id;
        this.menuId = menuId;
        this.orderDetail = orderDetail;
        this.price = price;
    }

    public MenuPrice(Integer id, Menu menuId, Integer price) {
        this.id = id;
        this.menuId = menuId;
        this.price = price;
    }

    public MenuPrice(Menu menuId, Integer price) {
        this.menuId = menuId;
        this.price = price;
    }

    public MenuPrice() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Menu getMenuId() {
        return menuId;
    }

    public void setMenuId(Menu menuId) {
        this.menuId = menuId;
    }

    public List<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MenuPrice{" +
                "id=" + id +
                ", menuId=" + menuId +
                ", price=" + price +
                '}';
    }
}
