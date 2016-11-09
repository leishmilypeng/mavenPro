package com.lp.common.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public interface IBaseService<T> {
	public void save(T entity);

	T get(Serializable id);

	public void delete(Serializable id);

	public void update(T entity);

	public List<T> getList(Map<String, Object> condition);
	
	public List<T> getList(Map<String, Object> condition,int start,int end);
	
	public int getListCount(Map<String, Object> condition);

	public void updateEntity(Object entity);

	public void delByCondition(Map<String,Object> condition);
}
