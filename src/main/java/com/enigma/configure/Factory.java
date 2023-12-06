package com.enigma.configure;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Factory {
    String PERSISTENCE_NAME = "jpa-wmb";
    public EntityManagerFactory openSession (){
        return Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
    }
}
