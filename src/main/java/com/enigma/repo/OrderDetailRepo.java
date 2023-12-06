package com.enigma.repo;

import com.enigma.entity.OrderDetail;

import java.util.List;

public interface OrderDetailRepo {
    List<OrderDetail> getAll ();
    void save(OrderDetail orderDetail);
    void remove(Integer id);
    OrderDetail getById (Integer id);
}
