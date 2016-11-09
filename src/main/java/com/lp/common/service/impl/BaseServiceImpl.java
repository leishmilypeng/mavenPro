package com.lp.common.service.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.lp.common.dao.BaseDao;
import com.lp.common.service.IBaseService;

public abstract class BaseServiceImpl<T> implements IBaseService<T>{

	protected Class<T> clazz;
	
	/**
	 * 获取该类对应的泛型实际类型
	 * 
	 * @return
	 */
	protected Class<T>  getParameterEntityType(){
		Type type = getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			clazz = (Class<T>) ((ParameterizedType) type)
					.getActualTypeArguments()[0];
		}
		return clazz;
	}
	
	public abstract BaseDao getDao();
	
	@Override
	public void save(T entity) {
		this.getDao().save(entity);
	}

	@Override
	public T get(Serializable id) {
		return this.getDao().get(getParameterEntityType(), id);
	}

	@Override
	public void delete(Serializable id) {
		this.getDao().remove(getParameterEntityType(), id);
	}

	@Override
	public void update(T entity) {
		this.getDao().updateEntity(entity);
	}

	@Override
	public List<T> getList(Map<String, Object> condition) {
		return this.getDao().getList(getParameterEntityType(), condition);
	}
	
	@Override
	public List<T> getList(Map<String, Object> condition,int start,int end) {
		return this.getDao().getList(getParameterEntityType(), condition,start,end);
	}

	@Override
	public void updateEntity(Object entity) {
		this.getDao().updateEntity(entity);
	}

	@Override
	public void delByCondition(Map<String, Object> condition) {
		this.getDao().delByCondition(condition, getParameterEntityType());
	}

	public int getListCount(Map<String, Object> condition){
		return this.getDao().getListCount(getParameterEntityType(), condition);
	}
}
