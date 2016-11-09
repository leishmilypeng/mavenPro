package com.lp.biz.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.lp.entity.TmScheduleJob;

/**
 * 并发情况下
 * @author CPR161
 *
 */
public class QuartzJobFactory implements Job {

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		TmScheduleJob scheduleJob = (TmScheduleJob) context.getMergedJobDataMap().get("scheduleJob");  
        TaskUtils.invokMethod(scheduleJob);
	}

}
