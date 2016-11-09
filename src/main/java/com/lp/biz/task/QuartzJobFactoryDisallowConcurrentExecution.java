package com.lp.biz.task;

import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.lp.entity.TmScheduleJob;

/**
 * 非并发情况下
 * @author CPR161
 * 
 *  禁止并发执行多个相同定义的JobDetail, 这个注解是加在Job类上的, 但意思并不是不能同时执行多个Job, 而是不能并发执行同一个Job Definition(由JobDetail定义),
 *  但是可以同时执行多个不同的JobDetail, 举例说明,我们有一个Job类,叫做SayHelloJob, 并在这个Job上加了这个注解, 然后在这个Job上定义了很多个JobDetail, 
 *  如sayHelloToJoeJobDetail, sayHelloToMikeJobDetail, 那么当scheduler启动时, 不会并发执行多个sayHelloToJoeJobDetail或者sayHelloToMikeJobDetail, 
 *  但可以同时执行sayHelloToJoeJobDetail跟sayHelloToMikeJobDetail
 *
 */
@DisallowConcurrentExecution
public class QuartzJobFactoryDisallowConcurrentExecution implements Job {

	Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		TmScheduleJob scheduleJob = (TmScheduleJob) context.getMergedJobDataMap().get("scheduleJob");  
		TaskUtils.invokMethod(scheduleJob);
	} 

}
