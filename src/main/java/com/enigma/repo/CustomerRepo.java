package com.enigma.repo;

import com.enigma.entity.Customer;

import java.util.List;

public interface CustomerRepo {
    List<Customer> getAll ();
    void save(Customer customer);
    void update(Customer customer);
    void remove(Integer id);
    Customer getById (Integer id);
}
