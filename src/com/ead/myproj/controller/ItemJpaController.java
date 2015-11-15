/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ead.myproj.controller;

import com.ead.myproj.controller.exceptions.NonexistentEntityException;
import com.ead.myproj.controller.exceptions.PreexistingEntityException;
import com.ead.myproj.controller.exceptions.RollbackFailureException;
import com.ead.myproj.entity.Item;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 * 
 * @author Sithmal
 */
public class ItemJpaController implements Serializable {
	private static final long serialVersionUID = 1L;

	public ItemJpaController(EntityManagerFactory emf) {
		this.emf = emf;
	}

	private EntityManagerFactory emf = null;

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void create(Item item) throws PreexistingEntityException,
			RollbackFailureException, Exception {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(item);
			em.getTransaction().commit();
		} catch (Exception ex) {
			try {
				em.getTransaction().rollback();
			} catch (Exception re) {
				throw new RollbackFailureException(
						"An error occurred attempting to roll back the transaction.",
						re);
			}
			/*
			 * if (findItem(item.getItemId()) != null) { throw new
			 * PreexistingEntityException("Item " + item + " already exists.",
			 * ex); }
			 */
			throw ex;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void edit(Item item) throws NonexistentEntityException,
			RollbackFailureException, Exception {
		EntityManager em = null;
		try {	
			em = getEntityManager();
			em.getTransaction().begin();
			item = em.merge(item);
			em.getTransaction().commit();
		} catch (Exception ex) {
			try {
				em.getTransaction().rollback();
			} catch (Exception re) {
				throw new RollbackFailureException(
						"An error occurred attempting to roll back the transaction.",
						re);
			}
			String msg = ex.getLocalizedMessage();
			/*		if (msg == null || msg.length() == 0) {
				Integer id = item.getItemId();
				if (findItem(id) == null) {
					throw new NonexistentEntityException("The item with id "
							+ id + " no longer exists.");
				}
			}*/
			throw ex;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void destroy(Integer id) throws NonexistentEntityException,
			RollbackFailureException, Exception {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			Item item;
			try {
				item = em.getReference(Item.class, id);
				item.getItemId();
			} catch (EntityNotFoundException enfe) {
				throw new NonexistentEntityException("The item with id " + id
						+ " no longer exists.", enfe);
			}
			em.remove(item);
			em.getTransaction().commit();
		} catch (Exception ex) {
			try {
				em.getTransaction().rollback();
			} catch (Exception re) {
				throw new RollbackFailureException(
						"An error occurred attempting to roll back the transaction.",
						re);
			}
			throw ex;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public List<Item> findItemEntities() {
		return findItemEntities(true, -1, -1);
	}

	public List<Item> findItemEntities(int maxResults, int firstResult) {
		return findItemEntities(false, maxResults, firstResult);
	}

	private List<Item> findItemEntities(boolean all, int maxResults,
			int firstResult) {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(Item.class));
			Query q = em.createQuery(cq);
			if (!all) {
				q.setMaxResults(maxResults);
				q.setFirstResult(firstResult);
			}
			return q.getResultList();
		} finally {
			em.close();
		}
	}

	public Item findItem(Integer id) {
		EntityManager em = getEntityManager();
		try {
			return em.find(Item.class, id);
		} finally {
			em.close();
		}
	}

	public int getItemCount() {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			Root<Item> rt = cq.from(Item.class);
			cq.select(em.getCriteriaBuilder().count(rt));
			Query q = em.createQuery(cq);
			return ((Long) q.getSingleResult()).intValue();
		} finally {
			em.close();
		}
	}

}
