package com.enigma.repo.impl;

import com.enigma.configure.Factory;
import com.enigma.entity.Order;
import com.enigma.repo.OrderRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class OrderRepoImpl implements OrderRepo {
    Factory factory = new Factory();
    EntityManagerFactory enf = factory.openSession();
    EntityManager em = enf.createEntityManager();

    @Override
    public List<Order> getAll() {
        List<Order> dataMenu = em.createQuery("select c from Order c", Order.class).getResultList();
        if (dataMenu.isEmpty()) System.out.println("There's no order yet");
        return dataMenu;
    }

    @Override
    public void save(Order order) {
        try {
            em.getTransaction().begin();
            em.persist(order);
            em.getTransaction().commit();
            getAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void remove(Integer id) {
        Order order = getById(id);
        try {
            if (order != null) {
                em.getTransaction().begin();
                em.remove(order);
                em.getTransaction().commit();
                getAll();
            } else {
                System.out.println("cannot delete order");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Order getById(Integer id) {
        Order order = em.find(Order.class, id);
        if (order == null) System.out.println("Order not found");
        return order;
    }
}
