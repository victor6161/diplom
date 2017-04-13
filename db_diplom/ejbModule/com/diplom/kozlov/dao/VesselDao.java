package com.diplom.kozlov.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.diplom.kozlov.entity.VesselEntity;
import com.diplom.kozlov.entityManager.PersistenceManager;

public class VesselDao {
	public void save(VesselEntity vesselEntity){
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(vesselEntity);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<VesselEntity> getVessels(){
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		List<VesselEntity> vesselEntity = em.createQuery("from VesselEntity").getResultList();
		em.getTransaction().commit();
		em.close();
		return vesselEntity;
	}


}
