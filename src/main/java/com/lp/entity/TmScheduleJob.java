package com.lp.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 用于动态配置定时任务
 * @author CPR161
 *
 */
@Entity
@Table(name = "tm_schedule_job")
public class TmScheduleJob implements java.io.Serializable {
	@Transient
	public static final String STATUS_RUNNING = "1";  
	@Transient
    public static final String STATUS_NOT_RUNNING = "0"; 
	@Transient
    public static final String CONCURRENT_IS = "1";  
	@Transient
    public static final String CONCURRENT_NOT = "0";  
    
	// Fields

	private Long jobId;
	private Timestamp createTime;
	private Timestamp updateTime;
	private String jobName;
	private String jobDesc;
	private String jobGroup;
	private String jobStatus;
	private String cronExpression;
	private String description;
	private String beanClass;
	private String isConcurrent;
	private String springId;
	private String methodName;

	// Constructors

	/** default constructor */
	public TmScheduleJob() {
	}

	/** minimal constructor */
	public TmScheduleJob(Long jobId) {
		this.jobId = jobId;
	}

	/** full constructor */
	public TmScheduleJob(Long jobId, Timestamp createTime,
			Timestamp updateTime, String jobName, String jobDesc,
			String jobGroup, String jobStatus, String cronExpression,
			String description, String beanClass, String isConcurrent,
			String springId, String methodName) {
		this.jobId = jobId;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.jobName = jobName;
		this.jobDesc = jobDesc;
		this.jobGroup = jobGroup;
		this.jobStatus = jobStatus;
		this.cronExpression = cronExpression;
		this.description = description;
		this.beanClass = beanClass;
		this.isConcurrent = isConcurrent;
		this.springId = springId;
		this.methodName = methodName;
	}

	// Property accessors
	@Id
	@Column(name = "job_id", unique = true, nullable = false, precision = 14, scale = 0)
	public Long getJobId() {
		return this.jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "update_time", length = 19)
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "job_name", length = 120)
	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	@Column(name = "job_desc", length = 400)
	public String getJobDesc() {
		return this.jobDesc;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	@Column(name = "job_group", length = 120)
	public String getJobGroup() {
		return this.jobGroup;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	@Column(name = "job_status", length = 8)
	public String getJobStatus() {
		return this.jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	@Column(name = "cron_expression", length = 120)
	public String getCronExpression() {
		return this.cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	@Column(name = "description", length = 400)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "bean_class", length = 200)
	public String getBeanClass() {
		return this.beanClass;
	}

	public void setBeanClass(String beanClass) {
		this.beanClass = beanClass;
	}

	@Column(name = "is_concurrent", length = 8)
	public String getIsConcurrent() {
		return this.isConcurrent;
	}

	public void setIsConcurrent(String isConcurrent) {
		this.isConcurrent = isConcurrent;
	}

	@Column(name = "spring_id", length = 200)
	public String getSpringId() {
		return this.springId;
	}

	public void setSpringId(String springId) {
		this.springId = springId;
	}

	@Column(name = "method_name", length = 120)
	public String getMethodName() {
		return this.methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}


}
