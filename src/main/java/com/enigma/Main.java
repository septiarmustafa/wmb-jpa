package com.enigma;

import com.enigma.configure.Factory;
import com.enigma.entity.*;
import com.enigma.repo.impl.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        Factory factory = new Factory();
        EntityManagerFactory enf = factory.openSession();
        EntityManager em = enf.createEntityManager();

        MenuRepoImpl menuRepo = new MenuRepoImpl();
        Menu menu = new Menu("Nasih Goreng S");
//        System.out.println(menu.getAll());
//        menuRepo.getById(1);
//        menuRepo.save(menu);
//        menuRepo.update(new Menu(3, "Nasi Goreng Special"));
//        menuRepo.remove(3);

        MenuPriceRepoImpl menuPriceRepo = new MenuPriceRepoImpl();
        MenuPrice menuPrice = new MenuPrice(menuRepo.getById(2), 15000);
//        System.out.println(menuPriceRepo.getAll());
//        menuPriceRepo.getById(1);
//        menuPriceRepo.save(menuPrice);
//        menuPriceRepo.update(new MenuPrice(1, menuRepo.getById(1), 6000 ));
//        menuPriceRepo.remove(1);

        CustomerRepoImpl customerRepo = new CustomerRepoImpl();
        Customer customer = new Customer("Septiar", "0877", false);
//        System.out.println(customerRepo.getAll());
//        customerRepo.getById(1);
//        customerRepo.save(customer);
//        customerRepo.remove(1);
//        customerRepo.update(new Customer(1,"Tiar", "087709124121", true));

        OrderRepoImpl orderRepo = new OrderRepoImpl();
        Order order = new Order(Date.valueOf("2023-12-05"), customerRepo.getById(1));
//        System.out.println(orderRepo.getAll());
//        orderRepo.getById(1);
//        orderRepo.save(order);
//        orderRepo.remove(1);

        OrderDetailRepoImpl orderDetailRepo = new OrderDetailRepoImpl();
        OrderDetail orderDetail = new OrderDetail(orderRepo.getById(1),menuPriceRepo.getById(1),10);
//        System.out.println(orderDetailRepo.getAll());
//        orderDetailRepo.getById(1);
//        orderDetailRepo.save(orderDetail);
//        orderDetailRepo.remove(1);

    }
}