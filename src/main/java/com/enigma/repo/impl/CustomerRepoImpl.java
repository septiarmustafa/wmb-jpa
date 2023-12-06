package com.enigma.repo.impl;

import com.enigma.configure.Factory;
import com.enigma.entity.Customer;
import com.enigma.repo.CustomerRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class CustomerRepoImpl implements CustomerRepo {

    Factory factory = new Factory();
    EntityManagerFactory enf = factory.openSession();
    EntityManager em = enf.createEntityManager();
    @Override
    public List<Customer> getAll() {
        List<Customer> data = em.createQuery("select c from Customer c", Customer.class).getResultList();
        if (data.isEmpty()) System.out.println("There's no customer yet");
        return data;
    }

    @Override
    public void save(Customer customer) {
        try {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
            getAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Customer customer) {
        try {
            if (getById(customer.getId()) != null) {
                em.getTransaction().begin();
                em.merge(customer);
                em.getTransaction().commit();
                getAll();
            } else {
                System.out.println("cannot update customer");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void remove(Integer id) {
        Customer customer = getById(id);
        try {
            if (customer != null) {
                em.getTransaction().begin();
                em.remove(customer);
                em.getTransaction().commit();
                getAll();
            } else {
                System.out.println("cannot delete customer");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Customer getById(Integer id) {
        Customer customer = em.find(Customer.class, id);
        if (customer == null)System.out.println("Customer not found");
        return customer;
    }
}
