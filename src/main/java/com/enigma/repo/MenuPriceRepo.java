package com.enigma.repo;

import com.enigma.entity.MenuPrice;

import java.util.List;

public interface MenuPriceRepo {
    List<MenuPrice> getAll ();
    void save(MenuPrice menuPrice);
    void update(MenuPrice menuPrice);
    void remove(Integer id);
    MenuPrice getById (Integer id);
}
