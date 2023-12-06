package com.enigma.repo.impl;

import com.enigma.configure.Factory;
import com.enigma.entity.MenuPrice;
import com.enigma.repo.MenuPriceRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class MenuPriceRepoImpl implements MenuPriceRepo {
    Factory factory = new Factory();
    EntityManagerFactory enf = factory.openSession();
    EntityManager em = enf.createEntityManager();
    @Override
    public List<MenuPrice> getAll() {
        List<MenuPrice> data = em.createQuery("select c from MenuPrice c", MenuPrice.class).getResultList();
        if (data.isEmpty()) System.out.println("There's no menu price yet");
        return data;
    }

    @Override
    public void save(MenuPrice menuPrice) {
        try {
            em.getTransaction().begin();
            em.persist(menuPrice);
            em.getTransaction().commit();
            getAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(MenuPrice menuPrice) {
        try {
            if (getById(menuPrice.getId()) != null) {
                em.getTransaction().begin();
                em.merge(menuPrice);
                em.getTransaction().commit();
                getAll();
            } else {
                System.out.println("cannot update menu price");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void remove(Integer id) {
        MenuPrice menuPrice = getById(id);
        try {
            if (menuPrice != null) {
                em.getTransaction().begin();
                em.remove(menuPrice);
                em.getTransaction().commit();
                getAll();
            } else {
                System.out.println("cannot delete menu price");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public MenuPrice getById(Integer id) {
        MenuPrice menuFound = em.find(MenuPrice.class, id);
        if (menuFound == null)System.out.println("Menu price not found");
        return menuFound;
    }
}
