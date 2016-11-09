package com.lp.biz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lp.biz.service.ITmScheduleJobService;
import com.lp.entity.TmScheduleJob;
import com.lp.init.SystemStartupInit;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	ITmScheduleJobService scheduleJobService;
	
	@RequestMapping(value="/removeJob.do")
    public ModelAndView removeJob(HttpServletRequest request,HttpServletResponse response){
    	
		// 这里从数据库中获取任务信息数据  
		Map<String,Object> cond = new HashMap<String,Object>();
		//加载库里面的配置
		List<TmScheduleJob> jobList = scheduleJobService.getList(cond);
		for(TmScheduleJob job : jobList){
			try {
				//移除现有的定时任务
				SystemStartupInit.removeJob(job);
			} catch (SchedulerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
    	ModelAndView mv = new ModelAndView("test/test");
        return mv;
    }
	
	@RequestMapping(value="/addJob.do")
    public ModelAndView addJob(HttpServletRequest request,HttpServletResponse response){
    	
		// 这里从数据库中获取任务信息数据  
		Map<String,Object> cond = new HashMap<String,Object>();
		//加载库里面的配置
		List<TmScheduleJob> jobList = scheduleJobService.getList(cond);
		for(TmScheduleJob job : jobList){
			try {
				//新增库里配置的定时任务
				SystemStartupInit.addJob(job);
			} catch (SchedulerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
    	ModelAndView mv = new ModelAndView("test/addJob");
        return mv;
    }
}
