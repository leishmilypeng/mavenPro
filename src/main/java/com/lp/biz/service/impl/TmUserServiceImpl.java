package com.lp.biz.service.impl;

import java.util.HashMap;
import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.lp.biz.dao.TmUserDao;
import com.lp.biz.service.ITmUserService;
import com.lp.common.dao.BaseDao;
import com.lp.common.service.impl.BaseServiceImpl;
import com.lp.entity.TmUser;

/*
 * 
 * 		@Autowired
 * 		@Qualifier("tmUserService")
 * 		ITmUserService userService;
 * 
 * 针对接口多实现的注解方式，需要在引用的地方指定需要需要注解的事哪个实现类，如上面所示
 *
 */
@Service("tmUserService")
public class TmUserServiceImpl extends BaseServiceImpl<TmUser> implements ITmUserService  {

	@Autowired
	private CacheManager cacheManager;
	
	@Override
	public BaseDao getDao() {
		// TODO Auto-generated method stub
		return new TmUserDao();
	}
	
	public void test() {
		//System.out.println("通过注解调用接口成功！");
		
		//EntityManager em = EntityManagerHelper.getEntityManager();
		//em.getTransaction().begin();
		//TmUser tt = this.get(new TmUserId("HD130100",90090000003680l));
		//TmUser tt = em.find(TmUser.class,new TmUserId("AA112111",3l));
		/*if(tt!=null){
			this.delete(tt.getId());
		}*/
		// em.getTransaction().commit();
		// em.close();
		/*Map<String,Object> cond = new HashMap<String,Object>();
		List<TmUser> list = this.getList(cond);
		if(list!=null&&list.size()>0){
			TmUser tu = list.get(0);
			new TmUserDao().remove(tu);
		}*/
		
		// 在service里面自定缓存方法
        //Object obj = cacheManager.getCache("myCache").get("test");
        Cache cache = cacheManager.getCache("myCache");
        if(cache!=null){
        	Element ele = cache.get("test");
        	List keys = cache.getKeys();
        	if(ele==null){
        		this.testUserCache();		// 属于内部调用，aop不生效
        	}
        	System.out.println("");
        }
		System.out.println("test ehcache");
		this.testUserCache();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.lp.biz.service.ITmUserService#testUserCache()
	 * 注意key的使用
	 * ********************
	 * 注意和限制
	 * 基于 proxy 的 spring aop 带来的内部调用问题上面介绍过 spring cache 的原理，即它是基于动态生成的 proxy 代理机制来对方法的调用进行切面，
	 * 这里关键点是对象的引用问题，如果对象的方法是内部调用（即 this 引用）而不是外部引用，则会导致 proxy 失效，那么我们的切面就失效，
	 * 也就是说上面定义的各种注释包括
	 *  @Cacheable	查询
	 *  @CachePut 	更新
	 *  @CacheEvict 删除
	 *  都会失效
	 *  eg	http://www.ibm.com/developerworks/cn/opensource/os-cn-spring-cache/
	 *  
	 *  同时使用多个缓存注解需要使用@Caching
	 *  @Caching(evict = { @CacheEvict("primary"), @CacheEvict(cacheNames="secondary", key="#p0") })
	 */
	@Cacheable(value = "myCache", key = "'testUserCache'")
	public List<TmUser> testUserCache()
	{
		System.out.println("select from db");
		return new TmUserDao().getList(TmUser.class, new HashMap<String,Object>());
	}
}
