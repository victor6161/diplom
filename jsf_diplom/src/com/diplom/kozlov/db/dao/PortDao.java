package com.diplom.kozlov.db.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.diplom.kozlov.db.entityManager.PersistenceManager;

import com.diplom.kozlov.entity.PortEntity;

public class PortDao {
	public List<PortEntity> getPorts(){
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		List<PortEntity> portEntity = em.createQuery("from PortEntity").getResultList();
		em.getTransaction().commit();
		em.close();
		return portEntity;
		
	}

	public void save(PortEntity portEntity) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(portEntity);
		em.getTransaction().commit();
		em.close();
		
	}

}
