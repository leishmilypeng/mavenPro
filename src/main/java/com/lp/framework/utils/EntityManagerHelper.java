package com.lp.framework.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class EntityManagerHelper {

	private static EntityManagerFactory emf=null;
	
	private static ThreadLocal<ThreadContext> threadLocal;
	
	private static Logger log = Logger.getLogger(EntityManagerHelper.class);
	/**
	 * 该类提供了线程局部 (thread-local) 变量。这些变量不同于它们的普通对应物，因为访问某个变量（通过其 get 或 set 方法）的每个线程都有自己的局部变量，
	 * 它独立于变量的初始化副本。ThreadLocal 实例通常是类中的 private static 字段，它们希望将状态与某一个线程（例如，用户 ID 或事务 ID）相关联。
	 */
	
	static {
		emf = (EntityManagerFactory) SpringContextHolder.getBean("entityManagerFactory");
		threadLocal = new ThreadLocal<ThreadContext>();
	}
	
	public static EntityManager getEntityManager() {
		
		ThreadContext context = threadLocal.get();
		EntityManager manager = null;
		if(context==null){
			manager = emf.createEntityManager();
			context = new ThreadContext();
			context.setManager(manager);
			threadLocal.set(context);
		}else{
			manager = context.getManager();
		}
		return manager;
	}
	
	public static void closeEntityManager() {
		ThreadContext context = threadLocal.get();
		if(context != null){
	        EntityManager em = context.getManager();
	        threadLocal.remove();
	        threadLocal.set(null);
	        if (em != null) em.close();
		}
	}
    
    public static void beginTransaction() {
    	getEntityManager().getTransaction().begin();
    }
    
    public static void commit() {
    	getEntityManager().getTransaction().commit();
    }  
    
    public static void rollback() {
    	getEntityManager().getTransaction().rollback();
    } 
	
	public static void log(String info, Level level, Throwable ex) {
		if(Level.ALL == level ){
			log.info(info, ex);
		} else if(Level.WARN == level){
			log.warn(info, ex);
		} else if(Level.ERROR == level){
			log.error(info, ex);
		} else if(Level.DEBUG == level ){
			log.debug(info, ex);
		}
    }
    
}
