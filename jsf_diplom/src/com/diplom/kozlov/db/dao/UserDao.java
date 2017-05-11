package com.diplom.kozlov.db.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.diplom.kozlov.db.entityManager.PersistenceManager;

import com.diplom.kozlov.entity.UserEntity;


public class UserDao {
	private static final Logger LOGGER = Logger.getLogger(UserDao.class);
	public void save(UserEntity userEntity){
		LOGGER.info("save");
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(userEntity);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<UserEntity> getUsers(){
		LOGGER.info("getUsers");
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		List<UserEntity> userEntity = em.createQuery("from UserEntity").getResultList();
		em.getTransaction().commit();
		em.close();
		return userEntity;
	}


}
