package com.diplom.kozlov.db.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.diplom.kozlov.db.entityManager.PersistenceManager;
import com.diplom.kozlov.entity.CountryEntity;
import com.diplom.kozlov.entity.RouteEntity;
import com.diplom.kozlov.entity.VesselEntity;
import com.diplom.kozlov.route.RouteController;

public class RouteDao {
	private static final Logger LOGGER = Logger.getLogger(RouteDao.class);
	public List<RouteEntity> getRoute(){
		LOGGER.info("getRoute");
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		List<RouteEntity> routeEntity = em.createQuery("from RouteEntity").getResultList();
		LOGGER.info( routeEntity );
		em.getTransaction().commit();
		em.close();
		return routeEntity;
	}
	
	public void save(RouteEntity routeEntity){
		LOGGER.info(routeEntity);
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(routeEntity);
		em.getTransaction().commit();
		em.close();
	}

	public void update(RouteEntity routeEntityInput) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		RouteEntity routeEntityOutput = em.find(RouteEntity.class, routeEntityInput.getId());
		
		routeEntityOutput.setPortFrom(routeEntityInput.getPortFrom());
		
		routeEntityOutput.setPortTo(routeEntityInput.getPortTo());
	
		routeEntityOutput.setNumPoints(routeEntityInput.getNumPoints());
	
		
		
		em.getTransaction().commit();
		em.close();
		
	}
	

}
