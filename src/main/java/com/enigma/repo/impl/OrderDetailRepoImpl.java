package com.enigma.repo.impl;

import com.enigma.configure.Factory;
import com.enigma.entity.OrderDetail;
import com.enigma.repo.OrderDetailRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class OrderDetailRepoImpl implements OrderDetailRepo {
    Factory factory = new Factory();
    EntityManagerFactory enf = factory.openSession();
    EntityManager em = enf.createEntityManager();

    @Override
    public List<OrderDetail> getAll() {
        List<OrderDetail> dataMenu = em.createQuery("select c from OrderDetail c", OrderDetail.class).getResultList();
        if (dataMenu.isEmpty()) System.out.println("There's no order detail yet");
        return dataMenu;
    }

    @Override
    public void save(OrderDetail orderDetail) {
        try {
            em.getTransaction().begin();
            em.persist(orderDetail);
            em.getTransaction().commit();
            getAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void remove(Integer id) {
        OrderDetail orderDetail = getById(id);
        try {
            if (orderDetail != null) {
                em.getTransaction().begin();
                em.remove(orderDetail);
                em.getTransaction().commit();
                getAll();
            } else {
                System.out.println("cannot delete order detail");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public OrderDetail getById(Integer id) {
        OrderDetail orderDetail = em.find(OrderDetail.class, id);
        if (orderDetail == null)System.out.println("Order not found");
        return orderDetail;
    }
}
