package com.diplom.kozlov.db.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.diplom.kozlov.db.entityManager.PersistenceManager;
import com.diplom.kozlov.entity.CountryEntity;

public class CountryDao {
	public void save(CountryEntity countryEntity){
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(countryEntity);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<CountryEntity> getCountries(){
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		List<CountryEntity> countryEntity = em.createQuery("from CountryEntity").getResultList();
		em.getTransaction().commit();
		em.close();
		return countryEntity;
	}
}
