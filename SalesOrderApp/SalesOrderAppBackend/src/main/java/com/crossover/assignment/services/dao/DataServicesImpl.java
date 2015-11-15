package com.crossover.assignment.services.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.crossover.assignment.dao.DataDao;

public class DataServicesImpl implements DataServices {

	@Autowired
	DataDao dataDao;

	public boolean addEntity(Object product) throws Exception {
		return dataDao.addEntity(product);
	}

	public Object getEntityById(Class clazz, long id) throws Exception {
		return dataDao.getEntityById(clazz, id);
	}

	public List<Object> getEntityList(Class clazz) throws Exception {
		return dataDao.getEntityList(clazz);
	}

	public boolean deleteEntity(Class clazz, long id) throws Exception {
		return dataDao.deleteEntity(clazz, id);
	}

}
