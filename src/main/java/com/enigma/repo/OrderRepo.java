package com.enigma.repo;


import com.enigma.entity.Order;

import java.util.List;

public interface OrderRepo {
    List<Order> getAll ();
    void save(Order order);
    void remove(Integer id);
    Order getById (Integer id);
}
