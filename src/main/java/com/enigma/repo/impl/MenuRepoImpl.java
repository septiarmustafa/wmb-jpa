package com.enigma.repo.impl;

import com.enigma.configure.Factory;
import com.enigma.entity.Menu;
import com.enigma.repo.MenuRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class MenuRepoImpl implements MenuRepo {
    Factory factory = new Factory();
    EntityManagerFactory enf = factory.openSession();
    EntityManager em = enf.createEntityManager();
    @Override
    public List<Menu> getAll() {
        List<Menu> dataMenu = em.createQuery("select c from Menu c", Menu.class).getResultList();
        if (dataMenu.isEmpty()) System.out.println("There's no menu yet");
        return dataMenu;
    }

    @Override
    public void save(Menu menu) {
        try {
            em.getTransaction().begin();
            em.persist(menu);
            em.getTransaction().commit();
            getAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Menu menu) {
        try {
            if (getById(menu.getId()) != null) {
                em.getTransaction().begin();
                em.merge(menu);
                em.getTransaction().commit();
                getAll();
            } else {
                System.out.println("cannot update menu");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void remove(Integer id) {
        Menu menu = getById(id);
        try {
            if (menu!= null) {
                em.getTransaction().begin();
                em.remove(menu);
                em.getTransaction().commit();
                getAll();
            } else {
                System.out.println("cannot delete menu");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Menu getById(Integer id) {
        Menu menuFound = em.find(Menu.class, id);
        if (menuFound == null)System.out.println("Menu not found");
        return menuFound;
    }
}
