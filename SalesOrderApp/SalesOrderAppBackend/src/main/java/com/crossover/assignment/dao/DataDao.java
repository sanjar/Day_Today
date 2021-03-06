package com.crossover.assignment.dao;

import java.util.List;

public interface DataDao {

	public boolean addEntity(Object entity) throws Exception;

	public Object getEntityById(Class clazz, String id) throws Exception;

	public List<Object> getEntityList(Class clazz) throws Exception;

	public boolean deleteEntity(Class clazz, String id) throws Exception;
}
