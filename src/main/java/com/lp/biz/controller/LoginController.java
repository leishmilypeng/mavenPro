package com.lp.biz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lp.common.service.IRedisService;
import com.lp.test.aop.Sleepable;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lp.biz.service.ITmUserService;
import com.lp.biz.service.impl.TmUserServiceImpl;
import com.lp.entity.TmUser;
import com.lp.framework.utils.Pager;
import com.lp.framework.utils.SpringContextHolder;
import com.lp.test.aop.TestBeans;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	@Qualifier("tmUserService")
	ITmUserService userService;
	
	@Autowired
	private CacheManager cacheManager;

	@Autowired
	private IRedisService redisService;
	
    @RequestMapping(value="/index.do")
    public ModelAndView index(HttpServletRequest request,HttpServletResponse response){
        ModelAndView mv = new ModelAndView("system/user/user_list");
        //userService.test();
        
//        TmUser tt = userService.get(new TmUserId("HD130100",90090000003680l));
		//TmUser tt = em.find(TmUser.class,new TmUserId("AA112111",3l));
//		if(tt!=null){
//			userService.delete(tt.getId());
//		}
        
        //this.userService.test();
        
        Map<String,Object> cond = new HashMap<String,Object>();
        List<TmUser> userList = this.userService.getList(cond);
        request.setAttribute("userList", userList);
/*

		redisService.set("hello","word");
		String redisKey = redisService.get("hello");
		System.out.println("==========redis value:"+redisKey+",======");
*/

		// spring切面
		Sleepable sleep = (Sleepable)SpringContextHolder.getBean("lina");
		sleep.beginsleep();

		return mv;
    }
    
    @RequestMapping(value="/ajaxUserList.do")
    @ResponseBody
    public Map<String, Object> ajaxUserList(HttpServletRequest request,HttpServletResponse response){
    	Map<String, Object> returnMap = new HashMap<String, Object>();
        Map<String,Object> cond = new HashMap<String,Object>();
        
        Map<String,Object> aoData = Pager.getAoDataMap(request.getParameter("aoData"));
        
        int iDisplayStart = Integer.valueOf(aoData.get("iDisplayStart").toString());
        int iDisplayLength = Integer.valueOf(aoData.get("iDisplayLength").toString());
        
        List<TmUser> list = userService.getList(cond,iDisplayStart,iDisplayLength);
        int count = userService.getListCount(cond);
		returnMap.put("aaData", list);
		returnMap.put("iTotalRecords", count);
		returnMap.put("iTotalDisplayRecords", count);
		
        // test ehcache annotation
        Cache cache = cacheManager.getCache("myCache");
        if(cache!=null){
        	Element ele = cache.get("testUserCache");
        	List keys = cache.getKeys();
        	if(ele==null){
        		this.userService.testUserCache();
        	}
        	System.out.println("第二次调用！");
        	// 第二次调用将使用缓存的内容
        	this.userService.testUserCache();
        	
        }
		
        return returnMap;
    }
    
    
    @RequestMapping(value="/test.do")
    public ModelAndView test(HttpServletRequest request,HttpServletResponse response){
    	System.out.println("---------------代理类测试-------------------");
    	System.out.println("---------------ITmUserService-------------------");
    	ITmUserService service = (ITmUserService) SpringContextHolder.getBean("tmUserService");
    	System.out.println(service);
    	// com.sun.proxy.$Proxy34
    	System.out.println(service.getClass().getName());
    	// 返回源代码中给出的底层类的简称。  输出底层类名为  $Proxy34，表示是使用jdk的Proxy实现
    	System.out.println(service.getClass().getSimpleName());
    	
    	System.out.println("---------------ITmUserService-------------------");
    	ITmUserService s = new TmUserServiceImpl();
    	System.out.println(s.getClass().getName());
    	System.out.println(s.getClass().getSimpleName());
    	
    	System.out.println("---------------TestBeans-------------------");
    	TestBeans tb = (TestBeans) SpringContextHolder.getBean("testBean");
    	System.out.println(tb);
    	System.out.println(tb.getClass().getName());
    	System.out.println(tb.getClass().getSimpleName());
    	
    	
    	
    	ModelAndView mv = new ModelAndView("system/user/test");
        return mv;
    }
    
}
