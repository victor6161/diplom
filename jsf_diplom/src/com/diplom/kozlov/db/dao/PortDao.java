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

}
