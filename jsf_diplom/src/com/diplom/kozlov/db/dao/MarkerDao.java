package com.diplom.kozlov.db.dao;

import javax.persistence.EntityManager;

import com.diplom.kozlov.db.entityManager.PersistenceManager;
import com.diplom.kozlov.entity.MarkerEntity;

public class MarkerDao {

	// merge не варик ибо значение кот в еntity null затираются
	public void update(MarkerEntity markerForUpdate) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		MarkerEntity markerEntity = em.find(MarkerEntity.class, markerForUpdate.getId());

		markerEntity.setLatitude(markerForUpdate.getLatitude());
		markerEntity.setLongitude(markerForUpdate.getLongitude());

		em.getTransaction().commit();
		em.close();
	}

}
