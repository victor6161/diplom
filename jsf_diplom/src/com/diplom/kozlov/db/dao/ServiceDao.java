package com.diplom.kozlov.db.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.diplom.kozlov.db.entityManager.PersistenceManager;
import com.diplom.kozlov.entity.RouteEntity;
import com.diplom.kozlov.entity.ServiceEntity;

public class ServiceDao {
	private static final Logger LOGGER = Logger.getLogger(ServiceDao.class);
	public void save(ServiceEntity serviceEntity) {
		LOGGER.info("save");
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(serviceEntity);
		em.getTransaction().commit();
		em.close();
		
	}
	public List<ServiceEntity> getList(){
		LOGGER.info("getRoute");
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		List<ServiceEntity> serviceEntity = em.createQuery("from ServiceEntity").getResultList();
		LOGGER.info( serviceEntity );
		em.getTransaction().commit();
		em.close();
		return serviceEntity;
	}

}
