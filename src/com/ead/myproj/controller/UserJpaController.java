/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ead.myproj.controller;

import com.ead.myproj.db.EMF;
import com.ead.myproj.entity.User;
import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class UserJpaController implements Serializable {
	private static final long serialVersionUID = 1L;

	public UserJpaController(EntityManagerFactory emf) {
		this.emf = emf;
	}

	private EntityManagerFactory emf = null;

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void create(User user){
		EntityManager em = getEntityManager();
		em.persist(user);
		em.close();

	}

	public List<User> findUser(String username, String password) {
		EntityManager em = getEntityManager();
		Query q = em
				.createQuery("select m from User m where m.username = :username and m.password = :password");
		q.setParameter("username", username);
		q.setParameter("password", password);
		List<User> userslist = q.getResultList();
		em.close();
		return userslist;
	}

	public List<User> findUser(String username) {
		EntityManager em = getEntityManager();
		Query q = em
				.createQuery("select p from User p where p.username = :username");
		q.setParameter("username", username);
		List<User> userslist = q.getResultList();
		return userslist;
	}

}
