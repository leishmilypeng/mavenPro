package com.lp.init;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdScheduler;
import org.springframework.beans.factory.annotation.Autowired;

import com.lp.biz.service.ITmScheduleJobService;
import com.lp.biz.task.QuartzJobFactory;
import com.lp.biz.task.QuartzJobFactoryDisallowConcurrentExecution;
import com.lp.entity.TmScheduleJob;
import com.lp.framework.utils.SpringContextHolder;

/**
 * 系统启动初始化类
 * @author CPR161
 *
 */
public class SystemStartupInit {
	
	private static Logger log = Logger.getLogger(SystemStartupInit.class);
	
	// 单利模式
	private static StdScheduler schedulerFactoryBean = null;
	
	@Autowired
	ITmScheduleJobService scheduleJobService;
	
	/*
	 * 出事执行方法
	 */
	public void init(){
		log.info("开始启动init初始化方法！");
		if(schedulerFactoryBean==null){
			 Object obj = SpringContextHolder.getBean("springJobSchedulerFactoryBean");
			schedulerFactoryBean = (StdScheduler)obj;
		}
		Scheduler scheduler = schedulerFactoryBean;  
		  
        // 这里从数据库中获取任务信息数据  
		Map<String,Object> cond = new HashMap<String,Object>();
		//加载库里面的配置
		List<TmScheduleJob> jobList = scheduleJobService.getList(cond);
      
        for (TmScheduleJob job : jobList) {  
            try {
				addJob(job);
			} catch (SchedulerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
        }  
	}
	
	/**
	 * 添加任务
	 * @param job
	 * @throws SchedulerException
	 */
	public static void addJob(TmScheduleJob job) throws SchedulerException {  
        if (job == null || TmScheduleJob.STATUS_RUNNING.equals(job.getJobStatus())) {  
            return;  
        }  
  
        Scheduler scheduler = schedulerFactoryBean;  
        log.debug(scheduler + "..........................................add job.............................................");  
        // 定时器唯一标识
        TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());  
  
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);  
  
        // 不存在，创建一个  
        if (null == trigger) {  
            Class clazz = TmScheduleJob.CONCURRENT_IS.equals(job.getIsConcurrent()) ? QuartzJobFactory.class : QuartzJobFactoryDisallowConcurrentExecution.class;  
  
            JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(job.getJobName(), job.getJobGroup()).build();  
  
            jobDetail.getJobDataMap().put("scheduleJob", job);  
  
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());  
  
            trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup()).withSchedule(scheduleBuilder).build();  
  
            scheduler.scheduleJob(jobDetail, trigger);  
        } else {  
            // Trigger已存在，那么更新相应的定时设置  
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());  
  
            // 按新的cronExpression表达式重新构建trigger  
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();  
  
            // 按新的trigger重新设置job执行  
            scheduler.rescheduleJob(triggerKey, trigger);  
        }  
    }  
	
	/**
	 * 移除任务
	 * @param job
	 * @throws SchedulerException
	 */
	public static void removeJob(TmScheduleJob job) throws SchedulerException { 
		//如果任务不存在或者正在运行不处理
		 if (job == null || TmScheduleJob.STATUS_RUNNING.equals(job.getJobStatus())) {  
	            return;  
	        }  
	  
	        Scheduler scheduler = schedulerFactoryBean;  
	        log.debug(scheduler + ".....................remove job..................................");  
	        // 定时器唯一标识
	        TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());  
	  
	        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);  
	        
	        
	        boolean success = scheduler.deleteJob(trigger.getJobKey());
	        if(success){
	        	log.debug(".....................success remove job..................................");
	        }else{
	        	log.debug(".....................failed remove job..................................");
	        }
		
	}
}
