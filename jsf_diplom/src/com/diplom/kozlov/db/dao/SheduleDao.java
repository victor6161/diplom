package com.diplom.kozlov.db.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.diplom.kozlov.db.entityManager.PersistenceManager;
import com.diplom.kozlov.entity.CountryEntity;
import com.diplom.kozlov.entity.SheduleEntity;
import com.diplom.kozlov.shedule.SheduleController;

public class SheduleDao {
	private static final Logger LOGGER = Logger.getLogger(SheduleDao.class);
	public List<SheduleEntity> getShedule(){
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		List<SheduleEntity> sheduleEntity = em.createQuery("from SheduleEntity").getResultList();
		em.getTransaction().commit();
		em.close();
		return sheduleEntity;
	}
	
	public void save(SheduleEntity sheduleEntity){
		LOGGER.info(sheduleEntity);
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(sheduleEntity);
		em.getTransaction().commit();
		em.close();
	}
	

}
