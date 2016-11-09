package com.lp.common.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao {
	/**
	 * 根据类和ID获取对象
	 * 
	 * @param <T>
	 * @param clazz
	 * @param id
	 * @return Java对象
	 */
	<T> T get(Class<T> clazz, Serializable id);

	/**
	 * 对象保存
	 * 
	 * @param T
	 *            表示任何Java对象
	 * @return 保存后Java对象
	 */
	<T> T save(T o);

	/**
	 * 根据类和ID删除对象
	 * 
	 * @param <T>
	 * @param clazz
	 * @param id
	 */
	<T> void remove(Class<T> clazz, Serializable id);

	/**
	 * 删除对象
	 * 
	 * @param <T>
	 * @param entity
	 */
	<T> void remove(Object entity);

	/**
	 * 获取指定HSQL的第一个对象
	 * 
	 * @param qlString
	 *            HSQL语句
	 * @param args
	 *            参数数组
	 * @return
	 */
	Object getFirst(String qlString, Object[] args);

	/**
	 * 根据类和条件返回第一个对象
	 * 
	 * @param <T>
	 * @param clazz
	 * @param condition
	 * @return
	 */
	<T> T getFirst(Class<T> clazz, Map<String, Object> condition);

	/**
	 * 根据HSQL查询返回列表
	 * 
	 * @param qlString
	 * @return
	 */
	@SuppressWarnings("unchecked")
	List getList(String qlString);

	/**
	 * 根据HSQL查询返回列表
	 * 
	 * @param qlString
	 * @param args
	 * @return
	 */
	@SuppressWarnings("unchecked")
	List getList(String qlString, Object[] args);

	/**
	 * 根据类及条件返回列表
	 * 
	 * @param <T>
	 * @param clazz
	 * @param condition
	 * @return
	 */
	<T> List<T> getList(Class<T> clazz, Map<String, Object> condition);
	
	/**
	 * 根据类及条件返回列表
	 * @param clazz
	 * @param condition
	 * @param start
	 * @param end
	 * @return
	 */
	<T> List<T> getList(Class<T> clazz, Map<String, Object> condition,int start,int end);
	
	/**
	 * 查询数量
	 * @param clazz
	 * @param condition
	 * @return
	 */
	<T> int getListCount(Class<T> clazz, Map<String, Object> condition);

	/**
	 * 获取指定类所有对象
	 * 
	 * @param <T>
	 * @param clazz
	 * @return
	 */
	<T> List<T> getAll(Class<T> clazz);

	/**
	 * 查询结果集
	 * @param hql
	 * @param start		起始位
	 * @param maxResult 结束位
	 * @return
	 */
	public List<?> query(String hql, int start, int maxResult);

	/**
	 * 
	 * @param hql
	 * @return
	 */
	public Object single(String hql);

	/**
	 * 通过hql语句进行更新
	 * @param hql
	 */
	public void update(String hql);

	/**
	 * 通过原生sql修改
	 * 
	 * @param hql
	 */
	public void updateByNativeSql(String sql, Object... args);

	/**
	 * 更新实体，属性值为空的不更新 （待处理）
	 * @param entity
	 */
	public void updateEntity(Object entity);


	/**
	 * 根据条件删除
	 * 
	 * @param condition
	 */
	public void delByCondition(Map<String, Object> condition, Class clz);
}
