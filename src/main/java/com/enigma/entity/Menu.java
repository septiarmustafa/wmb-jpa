package com.enigma.entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "m_menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "menu_name", length = 100)
    private String name;
    @OneToMany(mappedBy = "menuId" )
    private List<MenuPrice> menuPrice;


    public Menu(Integer id, String name, List<MenuPrice> menuPrice) {
        this.id = id;
        this.name = name;
        this.menuPrice = menuPrice;
    }
    public Menu(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Menu(String name) {
        this.name = name;
    }

    public Menu() {
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

    public List<MenuPrice> getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(List<MenuPrice> menuPrice) {
        this.menuPrice = menuPrice;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
