package com.lp.biz.task;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 需要继承QuartzJobBean
 */
public class SpringScheduleTask extends QuartzJobBean {

	public void execute(){
		System.out.println("启动定时任务！");
	}

	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		// TODO Auto-generated method stub
		this.execute();
	}
}
