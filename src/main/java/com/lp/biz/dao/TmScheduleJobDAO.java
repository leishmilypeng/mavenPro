package com.lp.biz.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Level;

import com.lp.common.dao.BaseDaoJpa;
import com.lp.entity.TmScheduleJob;
import com.lp.framework.utils.EntityManagerHelper;

public class TmScheduleJobDAO extends BaseDaoJpa<TmScheduleJob>{

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved TmScheduleJob entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * TmScheduleJobDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            TmScheduleJob entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(TmScheduleJob entity) {
		EntityManagerHelper.log("saving TmScheduleJob instance", Level.INFO,
				null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.ERROR, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent TmScheduleJob entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * TmScheduleJobDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            TmScheduleJob entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(TmScheduleJob entity) {
		EntityManagerHelper.log("deleting TmScheduleJob instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(TmScheduleJob.class,
					entity.getJobId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.ERROR, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved TmScheduleJob entity and return it or a copy
	 * of it to the sender. A copy of the TmScheduleJob entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = TmScheduleJobDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            TmScheduleJob entity to update
	 * @return TmScheduleJob the persisted TmScheduleJob entity instance, may
	 *         not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public TmScheduleJob update(TmScheduleJob entity) {
		EntityManagerHelper.log("updating TmScheduleJob instance", Level.INFO,
				null);
		try {
			TmScheduleJob result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.ERROR, re);
			throw re;
		}
	}

	public TmScheduleJob findById(Long id) {
		EntityManagerHelper.log(
				"finding TmScheduleJob instance with id: " + id, Level.INFO,
				null);
		try {
			TmScheduleJob instance = getEntityManager().find(
					TmScheduleJob.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.ERROR, re);
			throw re;
		}
	}

	/**
	 * Find all TmScheduleJob entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the TmScheduleJob property to query
	 * @param value
	 *            the property value to match
	 * @return List<TmScheduleJob> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<TmScheduleJob> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log(
				"finding TmScheduleJob instance with property: " + propertyName
						+ ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from TmScheduleJob model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.ERROR, re);
			throw re;
		}
	}

	/**
	 * Find all TmScheduleJob entities.
	 * 
	 * @return List<TmScheduleJob> all TmScheduleJob entities
	 */
	@SuppressWarnings("unchecked")
	public List<TmScheduleJob> findAll() {
		EntityManagerHelper.log("finding all TmScheduleJob instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from TmScheduleJob model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.ERROR, re);
			throw re;
		}
	}

}
