package com.enigma.repo;

import com.enigma.entity.Menu;

import java.util.List;

public interface MenuRepo {
    List<Menu> getAll ();
    void save(Menu menu);
    void update(Menu menu);
    void remove(Integer id);
    Menu getById (Integer id);
}
