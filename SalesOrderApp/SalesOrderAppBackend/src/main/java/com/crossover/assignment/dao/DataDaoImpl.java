package com.crossover.assignment.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class DataDaoImpl implements DataDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	public boolean addEntity(Object entity) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(entity);
		tx.commit();
		session.close();

		return false;
	}

	public Object getEntityById(Class clazz, long id) throws Exception {
		session = sessionFactory.openSession();
		Object entity = session.load(clazz, new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getEntityList(Class clazz) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Object> entityList = session.createCriteria(clazz).list();
		tx.commit();
		session.close();
		return entityList;
	}

	public boolean deleteEntity(Class clazz, long id) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(clazz, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

}
