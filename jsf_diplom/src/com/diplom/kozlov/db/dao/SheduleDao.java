package com.diplom.kozlov.db.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.diplom.kozlov.db.entityManager.PersistenceManager;
import com.diplom.kozlov.entity.CountryEntity;
import com.diplom.kozlov.entity.SheduleEntity;

public class SheduleDao {
	public List<SheduleEntity> getShedule(){
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		List<SheduleEntity> sheduleEntity = em.createQuery("from SheduleEntity").getResultList();
		em.getTransaction().commit();
		em.close();
		return sheduleEntity;
	}
	
	public void save(SheduleEntity sheduleEntity){
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(sheduleEntity);
		em.getTransaction().commit();
		em.close();
	}
	

}
