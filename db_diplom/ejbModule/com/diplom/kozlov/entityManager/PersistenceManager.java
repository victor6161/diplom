package com.diplom.kozlov.entityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
public enum PersistenceManager {
  INSTANCE;// чтобы только один раз создавался объект
 
  private EntityManagerFactory emFactory;
 
  private PersistenceManager() {
    // "jpa-example" was the value of the name attribute of the
    // persistence-unit element.
    emFactory = Persistence.createEntityManagerFactory("jpa-example");
  }
 
  public EntityManager getEntityManager() {
    return emFactory.createEntityManager();
  }
 
  public void close() {
    emFactory.close();
  }
}