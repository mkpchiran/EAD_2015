/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ead.myproj.controller;

import com.ead.myproj.controller.exceptions.NonexistentEntityException;
import com.ead.myproj.controller.exceptions.PreexistingEntityException;
import com.ead.myproj.controller.exceptions.RollbackFailureException;
import com.ead.myproj.entity.Sistercompany;
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
 * @author
 */
public class SistercompanyJpaController implements Serializable {

	public SistercompanyJpaController(EntityManagerFactory emf) {
		this.emf = emf;
	}

	private EntityManagerFactory emf = null;

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void create(Sistercompany sistercompany) throws RollbackFailureException, Exception {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(sistercompany);
			em.getTransaction().commit();
		} catch (Exception ex) {
			try {
				em.getTransaction().rollback();
			} catch (Exception re) {
				throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
			}
			/*
			 * if (findSistercompany(sistercompany.getCompanyId()) != null) {
			 * throw new PreexistingEntityException("Sistercompany " +
			 * sistercompany + " already exists.", ex); }
			 */
			throw ex;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	/*
	 * public void edit(Sistercompany sistercompany) throws
	 * NonexistentEntityException, RollbackFailureException, Exception {
	 * EntityManager em = null; try { em = getEntityManager();
	 * em.getTransaction().begin(); sistercompany = em.merge(sistercompany);
	 * em.getTransaction().commit(); } catch (Exception ex) { try {
	 * em.getTransaction().rollback(); } catch (Exception re) { throw new
	 * RollbackFailureException(
	 * "An error occurred attempting to roll back the transaction.", re); }
	 * String msg = ex.getLocalizedMessage(); if (msg == null || msg.length() ==
	 * 0) { Integer id = sistercompany.getCompanyId(); if (findSistercompany(id)
	 * == null) { throw new NonexistentEntityException(
	 * "The sistercompany with id " + id + " no longer exists."); } } throw ex;
	 * } finally { if (em != null) { em.close(); } } }
	 */

	//////////////////////////////////////////////////
	/*
	 * public void destroy(Integer id) throws NonexistentEntityException,
	 * RollbackFailureException, Exception { EntityManager em = null; try {
	 * utx.begin(); em = getEntityManager(); Sistercompany sistercompany; try {
	 * sistercompany = em.getReference(Sistercompany.class, id);
	 * sistercompany.getCompanyId(); } catch (EntityNotFoundException enfe) {
	 * throw new NonexistentEntityException("The sistercompany with id " + id +
	 * " no longer exists.", enfe); } em.remove(sistercompany); utx.commit(); }
	 * catch (Exception ex) { try { utx.rollback(); } catch (Exception re) {
	 * throw new RollbackFailureException(
	 * "An error occurred attempting to roll back the transaction.", re); }
	 * throw ex; } finally { if (em != null) { em.close(); } } }
	 */

	/////////////////////////////////////////////////////////////////
	/*
	 * 
	 * public List<Sistercompany> findSistercompanyEntities() { return
	 * findSistercompanyEntities(true, -1, -1); }
	 * 
	 * public List<Sistercompany> findSistercompanyEntities(int maxResults, int
	 * firstResult) { return findSistercompanyEntities(false, maxResults,
	 * firstResult); }
	 * 
	 * private List<Sistercompany> findSistercompanyEntities(boolean all, int
	 * maxResults, int firstResult) { EntityManager em = getEntityManager(); try
	 * { CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
	 * cq.select(cq.from(Sistercompany.class)); Query q = em.createQuery(cq); if
	 * (!all) { q.setMaxResults(maxResults); q.setFirstResult(firstResult); }
	 * return q.getResultList(); } finally { em.close(); } }
	 * 
	 * public Sistercompany findSistercompany(Integer id) { EntityManager em =
	 * getEntityManager(); try { return em.find(Sistercompany.class, id); }
	 * finally { em.close(); } }
	 * 
	 */

	public int getSistercompanyCount() {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			Root<Sistercompany> rt = cq.from(Sistercompany.class);
			cq.select(em.getCriteriaBuilder().count(rt));
			Query q = em.createQuery(cq);
			return ((Long) q.getSingleResult()).intValue();
		} finally {
			em.close();
		}
	}

}
