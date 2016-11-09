package com.lp.entity;

import java.sql.Timestamp;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * TmUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tm_user")
public class TmUser implements java.io.Serializable {

	// Fields

	private TmUserId id;
	@Transient
	private String entityName;
	@Transient
	private String entityShortName;
	private String orgCode;
	private String employeeNo;
	private String userCode;
	private String positionCode;
	private String userName;
	private String password;
	private Integer isServiceAdvisor;
	private Integer isConsultant;
	private Integer userStatus;
	private Timestamp loginLastTime;
	private String serialNo;
	private Integer serialTag;
	private Integer useInfohere;
	private Long createBy;
	private Timestamp createDate;
	private Long updateBy;
	private Timestamp updateDate;
	private Long ver;
	private String groupUserId;
	private Integer isSalesManager;
	private Integer isGeneralManager;
	private Timestamp ddcnUpdateDate;
	private Integer isUpload;
	private Timestamp submitTime;
	private Integer hasExportPerm;
	private Integer hasDeletePerm;

	@Transient
	private String orgName;
	
	// Constructors
	@Transient
	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	/** default constructor */
	public TmUser() {
	}

	/** minimal constructor */
	public TmUser(TmUserId id, String orgCode, String employeeNo,
			String userCode, String userName) {
		this.id = id;
		this.orgCode = orgCode;
		this.employeeNo = employeeNo;
		this.userCode = userCode;
		this.userName = userName;
	}

	/** full constructor */
	public TmUser(TmUserId id, String orgCode, String employeeNo,
			String userCode, String positionCode, String userName,
			String password, Integer isServiceAdvisor, Integer isConsultant,
			Integer userStatus, Timestamp loginLastTime, String serialNo,
			Integer serialTag, Integer useInfohere, Long createBy,
			Timestamp createDate, Long updateBy, Timestamp updateDate,
			Long ver, String groupUserId, Integer isSalesManager,
			Integer isGeneralManager, Timestamp ddcnUpdateDate,
			Integer isUpload, Timestamp submitTime) {
		this.id = id;
		this.orgCode = orgCode;
		this.employeeNo = employeeNo;
		this.userCode = userCode;
		this.positionCode = positionCode;
		this.userName = userName;
		this.password = password;
		this.isServiceAdvisor = isServiceAdvisor;
		this.isConsultant = isConsultant;
		this.userStatus = userStatus;
		this.loginLastTime = loginLastTime;
		this.serialNo = serialNo;
		this.serialTag = serialTag;
		this.useInfohere = useInfohere;
		this.createBy = createBy;
		this.createDate = createDate;
		this.updateBy = updateBy;
		this.updateDate = updateDate;
		this.ver = ver;
		this.groupUserId = groupUserId;
		this.isSalesManager = isSalesManager;
		this.isGeneralManager = isGeneralManager;
		this.ddcnUpdateDate = ddcnUpdateDate;
		this.isUpload = isUpload;
		this.submitTime = submitTime;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "entityCode", column = @Column(name = "entity_code", nullable = false, length = 8)),
			@AttributeOverride(name = "userId", column = @Column(name = "user_id", nullable = false, precision = 14, scale = 0)) })
	public TmUserId getId() {
		return this.id;
	}

	public void setId(TmUserId id) {
		this.id = id;
	}

	@Column(name = "org_code", nullable = false, length = 30)
	public String getOrgCode() {
		return this.orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	@Column(name = "employee_no", nullable = false, length = 4)
	public String getEmployeeNo() {
		return this.employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	@Column(name = "user_code", nullable = false, length = 30)
	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	@Column(name = "position_code", length = 4)
	public String getPositionCode() {
		return this.positionCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	@Column(name = "user_name", nullable = false, length = 30)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password", length = 30)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "is_service_advisor", precision = 8, scale = 0)
	public Integer getIsServiceAdvisor() {
		return this.isServiceAdvisor;
	}

	public void setIsServiceAdvisor(Integer isServiceAdvisor) {
		this.isServiceAdvisor = isServiceAdvisor;
	}

	@Column(name = "is_consultant", precision = 8, scale = 0)
	public Integer getIsConsultant() {
		return this.isConsultant;
	}

	public void setIsConsultant(Integer isConsultant) {
		this.isConsultant = isConsultant;
	}

	@Column(name = "user_status", precision = 8, scale = 0)
	public Integer getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	@Column(name = "login_last_time", length = 19)
	public Timestamp getLoginLastTime() {
		return this.loginLastTime;
	}

	public void setLoginLastTime(Timestamp loginLastTime) {
		this.loginLastTime = loginLastTime;
	}

	@Column(name = "serial_no", length = 30)
	public String getSerialNo() {
		return this.serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	@Column(name = "serial_tag", precision = 8, scale = 0)
	public Integer getSerialTag() {
		return this.serialTag;
	}

	public void setSerialTag(Integer serialTag) {
		this.serialTag = serialTag;
	}

	@Column(name = "use_infohere", precision = 8, scale = 0)
	public Integer getUseInfohere() {
		return this.useInfohere;
	}

	public void setUseInfohere(Integer useInfohere) {
		this.useInfohere = useInfohere;
	}

	@Column(name = "create_by", precision = 14, scale = 0)
	public Long getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	@Column(name = "create_date", length = 19)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Column(name = "update_by", precision = 14, scale = 0)
	public Long getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	@Column(name = "update_date", length = 19)
	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "ver", precision = 10, scale = 0)
	public Long getVer() {
		return this.ver;
	}

	public void setVer(Long ver) {
		this.ver = ver;
	}

	@Column(name = "group_user_id", length = 20)
	public String getGroupUserId() {
		return this.groupUserId;
	}

	public void setGroupUserId(String groupUserId) {
		this.groupUserId = groupUserId;
	}

	@Column(name = "is_sales_manager", precision = 8, scale = 0)
	public Integer getIsSalesManager() {
		return this.isSalesManager;
	}

	public void setIsSalesManager(Integer isSalesManager) {
		this.isSalesManager = isSalesManager;
	}

	@Column(name = "is_general_manager", precision = 8, scale = 0)
	public Integer getIsGeneralManager() {
		return this.isGeneralManager;
	}

	public void setIsGeneralManager(Integer isGeneralManager) {
		this.isGeneralManager = isGeneralManager;
	}

	@Column(name = "ddcn_update_date", length = 19)
	public Timestamp getDdcnUpdateDate() {
		return this.ddcnUpdateDate;
	}

	public void setDdcnUpdateDate(Timestamp ddcnUpdateDate) {
		this.ddcnUpdateDate = ddcnUpdateDate;
	}

	@Column(name = "is_upload", precision = 8, scale = 0)
	public Integer getIsUpload() {
		return this.isUpload;
	}

	public void setIsUpload(Integer isUpload) {
		this.isUpload = isUpload;
	}

	@Column(name = "submit_time", length = 19)
	public Timestamp getSubmitTime() {
		return this.submitTime;
	}

	public void setSubmitTime(Timestamp submitTime) {
		this.submitTime = submitTime;
	}
	
	@Transient
	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	@Transient
	public String getEntityShortName() {
		return entityShortName;
	}

	public void setEntityShortName(String entityShortName) {
		this.entityShortName = entityShortName;
	}

	@Column(name = "has_export_perm", precision = 8, scale = 0)
	public Integer getHasExportPerm() {
		return hasExportPerm;
	}

	public void setHasExportPerm(Integer hasExportPerm) {
		this.hasExportPerm = hasExportPerm;
	}

	@Column(name = "has_delete_perm", precision = 8, scale = 0)
	public Integer getHasDeletePerm() {
		return hasDeletePerm;
	}

	public void setHasDeletePerm(Integer hasDeletePerm) {
		this.hasDeletePerm = hasDeletePerm;
	}

	

}