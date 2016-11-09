package com.lp.common.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.lp.framework.exception.BaseException;
import com.lp.framework.utils.EntityManagerHelper;

/**
 * 
 * @author CPR161
 * dao实现类，不需要开人员去考虑开启和关闭EntityManager，直接传入相应的入参就可以使用
 * @param <T>
 */
public class BaseDaoJpa<T> implements BaseDao {

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}
	
	public List<T> getAllList(String hql,Class<T> clazz){
		List<T> resultList = new ArrayList<T>();
		resultList = this.getEntityManager().createQuery(hql,clazz).getResultList();
		return resultList;
	}

	@Override
	public <T> T get(Class<T> clazz, Serializable id) {
		return this.getEntityManager().find(clazz, id);
	}

	@Override
	public <T> T save(T o) {
		return this.getEntityManager().merge(o);
	}

	@Override
	public <T> void remove(Class<T> clazz, Serializable id) {
		this.getEntityManager().remove(this.get(clazz, id));
	}

	/**
	 * Removing a detached instance
	 * 
	 * 通过调用remove()方法删除一个受控的实体。如果实体声明为级联删除(cascade=REMOVE 或者cascade=ALL )，
	 * 被关联的实体也会被删除。在一个新建状态的实体上调用remove()操作，将被忽略。如果在游离实体上调用remove()操作，
	 * 将抛出 IllegalArgumentException，相关的事务将回滚。如果在已经删除的实体上执行remove()操作，也会被忽略；
	 * 需要将游离态的实体持久化到数据库，转化为受控态
	 *  merge(T entity) 将一个游离态的实体持久化到数据库中，并转换为受控态的实体；
	 * 下面介绍对象的状态 
	 * 	1 new/transient   新建的对象，或者是说这个对象没有加入到持久化上下文当中。 
	 * 	2 managed   对象存在持久化上下文中
	 *  3 detach   对象脱离了持久化上下文 
	 *  ????????????????????????
	 */
	@Override
	public <T> void remove(Object entity) {
		// 将一个游离态的实体持久化到数据库中，并转换为受控态的实体；
		//Object newObj = this.getEntityManager().merge(entity);
		//根据主键从数据库中删除一个对象，这个对象的状态必须是managed，否则会抛出IllegalArgumentException
		this.getEntityManager().remove(entity);

	}

	@Override
	public Object getFirst(String qlString, Object[] args) {
		List<T> list = this.getList(qlString, args);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public <T> T getFirst(Class<T> clazz, Map<String, Object> condition) {
		List<T> list = this.getList(clazz, condition);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List getList(String qlString) {
		return this.getList(qlString, null);
	}

	@Override
	public List getList(String qlString, Object[] args) {
		List list = new ArrayList();
		try {
			Query query = getEntityManager().createNativeQuery(qlString);
			int pos = 1;
			for(Object obj : args){
				query.setParameter(pos, obj);
				pos++;
			}
			list = query.getResultList();
			
		} catch (RuntimeException re) {
			throw re;
		}
		return list;
	}

	@Override
	public <T> List<T> getList(Class<T> clazz, Map<String, Object> condition) {
		List<T> list = new ArrayList();
		String claName = clazz.getSimpleName();
		StringBuffer sql = new StringBuffer(" from ").append(claName);
		sql.append(" where 1=1 ");
		Set<Map.Entry<String,Object>> keys = condition.entrySet();
		StringBuffer whereSql = new StringBuffer();
		List values = new ArrayList();
		for(Map.Entry<String,Object> key : keys){
			whereSql.append(" and ").append(key.getKey()).append(" = ").append("?");
			values.add(key.getValue());
		}
		sql.append(whereSql);
		Query query = this.getEntityManager().createQuery(sql.toString());
		if(values.size()>0){
			// 避免sql注入，采用预处理方式
			int pos = 1;
			for(Object obj : values){
				query.setParameter(pos, obj);
				pos++;
			}
		}
		list = query.getResultList();
		return list;
	}
	
	@Override
	public <T> List<T> getList(Class<T> clazz, Map<String, Object> condition,int start,int end) {
		List<T> list = new ArrayList();
		String claName = clazz.getSimpleName();
		StringBuffer sql = new StringBuffer(" from ").append(claName);
		sql.append(" where 1=1 ");
		Set<Map.Entry<String,Object>> keys = condition.entrySet();
		StringBuffer whereSql = new StringBuffer();
		List values = new ArrayList();
		for(Map.Entry<String,Object> key : keys){
			whereSql.append(" and ").append(key.getKey()).append(" = ").append("?");
			values.add(key.getValue());
		}
		sql.append(whereSql);
		Query query = this.getEntityManager().createQuery(sql.toString());
		if(values.size()>0){
			// 避免sql注入，采用预处理方式
			int pos = 1;
			for(Object obj : values){
				query.setParameter(pos, obj);
				pos++;
			}
		}
		query.setFirstResult(start);
		query.setMaxResults(end);
		list = query.getResultList();
		return list;
	}

	@Override
	public <T> List<T> getAll(Class<T> clazz) {
		return this.getList(clazz, null);
	}

	@Override
	public List<?> query(String hql, int start, int maxResult) {
		List list = new ArrayList();
		try {
			Query query = getEntityManager().createQuery(hql);
			query.setFirstResult(start);
			query.setMaxResults(maxResult);
			list = query.getResultList();
			
		} catch (RuntimeException re) {
			throw re;
		}
		return list;
	}

	@Override
	public Object single(String hql) {
		// TODO Auto-generated method stub
		try {
			Query query = getEntityManager().createQuery(hql);
			List list = query.getResultList();
			if(list!=null&&list.size()>0){
				return list.get(0);
			}else{
				return null;
			}
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public void update(String hql) {
		// TODO Auto-generated method stub
		try {
			Query query = getEntityManager().createQuery(hql);
			query.executeUpdate();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public void updateByNativeSql(String sql, Object... args) {
		try {
			Query query = getEntityManager().createNativeQuery(sql);
			for (int i = 0; i < args.length; i++) {
				query.setParameter(i + 1, args[i]);
			}
			query.executeUpdate();
		} catch (RuntimeException re) {
			throw re;
		}
		
	}

	@Override
	public void updateEntity(Object entity) {
		// 更新实体，实体字段采用注解实现，需要首先判断使用包含主键,注解@Transient不应包括在更新属性中
		/*
		 * getFields()获得某个类的所有的公共（public）的字段，包括父类。 
		 * getDeclaredFields()获得某个类的所有申明的字段，即包括public、private和proteced，但是不包括父类的申明字段。 
		*/
		
		/*
		String idName = "";
		boolean breakFlag = false;
		Field [] fields = entity.getClass().getDeclaredFields();
		for(Field field : fields){
			 Annotation[] annotations = field.getDeclaredAnnotations();
			 for(Annotation anno : annotations){
				 if(anno instanceof EmbeddedId || anno instanceof Id){
					 idName = field.getName().substring(3);
					 breakFlag = true;
					 break;
				 }
				 if(breakFlag){
					 break;
				 }
			 }
		}
		//存在主键
		if(StringUtils.isNotEmpty(idName)){
			String className = entity.getClass().getSimpleName();
			StringBuffer sql = new StringBuffer();
			sql.append(" update ").append(className).append(" set ");
			
			StringBuffer setSql = new StringBuffer();
		}
		*/
	}


	@Override
	public void delByCondition(Map<String, Object> condition, Class clz) {
		// 根据条件删除数据
		String claName = clz.getSimpleName();
		try {
			StringBuffer sql = new StringBuffer(" delete from ").append(claName);
			if(condition==null||condition.isEmpty()){
				throw new BaseException("删除方法条件不能为空！");
			}else{
				sql.append(" where 1=1 ");
				Set<Map.Entry<String,Object>> keys = condition.entrySet();
				StringBuffer whereSql = new StringBuffer();
				List values = new ArrayList();
				for(Map.Entry<String,Object> key : keys){
					whereSql.append(" and ").append(key.getKey()).append(" = ").append("?");
					values.add(key.getValue());
				}
				sql.append(whereSql);
				if(values.size()==0){
					throw new BaseException("删除方法条件不能为空！");
				}else{
					// 避免sql注入，采用预处理方式
					Query query = this.getEntityManager().createQuery(sql.toString());
					int pos = 1;
					for(Object obj : values){
						query.setParameter(pos, obj);
						pos++;
					}
					query.executeUpdate();
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public <T> int getListCount(Class<T> clazz, Map<String, Object> condition) {
		// TODO Auto-generated method stub
		List<T> list = new ArrayList();
		String claName = clazz.getSimpleName();
		// hql不识别count(1),只能用count(*)
		StringBuffer sql = new StringBuffer(" select count(*) from ").append(claName);
		sql.append(" where 1=1 ");
		Set<Map.Entry<String,Object>> keys = condition.entrySet();
		StringBuffer whereSql = new StringBuffer();
		List values = new ArrayList();
		for(Map.Entry<String,Object> key : keys){
			whereSql.append(" and ").append(key.getKey()).append(" = ").append("?");
			values.add(key.getValue());
		}
		sql.append(whereSql);
		Query query = this.getEntityManager().createQuery(sql.toString());
		int pos = 1;
		for(Object obj : values){
			query.setParameter(pos, obj);
			pos++;
		}
		Long obj = (Long) query.getSingleResult();
		return obj.intValue();
	}
	
}
