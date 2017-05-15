package com.diplom.kozlov.db.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.diplom.kozlov.db.entityManager.PersistenceManager;
import com.diplom.kozlov.entity.PortEntity;
import com.diplom.kozlov.entity.VesselEntity;

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

	public void update(VesselEntity vesselEntityInput) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		VesselEntity vesselEntityOutput = em.find(VesselEntity.class, vesselEntityInput.getId());
		
		vesselEntityOutput.setType(vesselEntityInput.getType());
		vesselEntityOutput.setLoadCapacity(vesselEntityInput.getLoadCapacity());
		vesselEntityOutput.setFuelConsumption(vesselEntityInput.getFuelConsumption());
		vesselEntityOutput.setAverageSpeed(vesselEntityInput.getAverageSpeed());
		
		
		em.getTransaction().commit();
		em.close();
		
	}


}
