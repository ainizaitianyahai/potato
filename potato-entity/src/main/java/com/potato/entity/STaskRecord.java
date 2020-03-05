package com.potato.entity;
import java.util.Date;

import org.beetl.sql.core.annotatoin.AutoID;

/* 
* 
* gen by beetlsql 2019-02-23
*/
public class STaskRecord  {
	//主键
	@AutoID
	private Integer id ;
	//优先级
	private Integer priority ;
	//影响分支
	private String branch ;
	//创建人
	private String creator ;
	//影响域
	private String influence ;
	//状态
	private String state ;
	//任务主键
	private Integer taskId ;
	//创建时间
	private Date createTime ;
	//计划完成时间
	private Date willFinishTime ;
	//更改说明
	private String modifierNote;	
	//验证说明
	private String verifyNote;	
	//需求分析说明
	private String rAnalyseNote;
	//需求设计说明
	private String rDesignNote;
	//需求实现说明
	private String rRealizeNote;
	//任务处理说明
	private String tDisposeNote;
	//类型
	private String type;
	//创建人id
	private String creatorId;
//	//创建人id
//	private String rDesignId;
//	//创建人id
//	private String rRealizeId;
//	//创建人id
//	private String tDisposeId;
//	
	public STaskRecord() {
	}
	
	public Integer getId(){
		return  id;
	}
	public void setId(Integer id ){
		this.id = id;
	}
	
	/**优先级
	*@return 
	*/
	public Integer getPriority(){
		return  priority;
	}
	/**优先级
	*@param  priority
	*/
	public void setPriority(Integer priority ){
		this.priority = priority;
	}
	
	/**影响分支
	*@return 
	*/
	public String getBranch(){
		return  branch;
	}
	/**影响分支
	*@param  branch
	*/
	public void setBranch(String branch ){
		this.branch = branch;
	}
	
	/**创建人
	*@return 
	*/
	public String getCreator(){
		return  creator;
	}
	/**创建人
	*@param  creator
	*/
	public void setCreator(String creator ){
		this.creator = creator;
	}
	
	/**影响域
	*@return 
	*/
	public String getInfluence(){
		return  influence;
	}
	/**影响域
	*@param  influence
	*/
	public void setInfluence(String influence ){
		this.influence = influence;
	}
	
	/**状态
	*@return 
	*/
	public String getState(){
		return  state;
	}
	/**状态
	*@param  state
	*/
	public void setState(String state ){
		this.state = state;
	}
	
	/**任务编号
	*@return 
	*/
	public Integer getTaskId(){
		return  taskId;
	}
	/**任务编号
	*@param  taskId
	*/
	public void setTaskId(Integer	 taskId ){
		this.taskId = taskId;
	}
	
	/**创建时间
	*@return 
	*/
	public Date getCreateTime(){
		return  createTime;
	}
	/**创建时间
	*@param  createTime
	*/
	public void setCreateTime(Date createTime ){
		this.createTime = createTime;
	}
	
	/**计划完成时间
	*@return 
	*/
	public Date getWillFinishTime(){
		return  willFinishTime;
	}
	/**计划完成时间
	*@param  willFinishTime
	*/
	public void setWillFinishTime(Date willFinishTime ){
		this.willFinishTime = willFinishTime;
	}

	public String getModifierNote() {
		return modifierNote;
	}

	public void setModifierNote(String modifierNote) {
		this.modifierNote = modifierNote;
	}

	public String getVerifyNote() {
		return verifyNote;
	}

	public void setVerifyNote(String verifyNote) {
		this.verifyNote = verifyNote;
	}

	public String getrAnalyseNote() {
		return rAnalyseNote;
	}

	public void setrAnalyseNote(String rAnalyseNote) {
		this.rAnalyseNote = rAnalyseNote;
	}

	public String getrDesignNote() {
		return rDesignNote;
	}

	public void setrDesignNote(String rDesignNote) {
		this.rDesignNote = rDesignNote;
	}

	public String getrRealizeNote() {
		return rRealizeNote;
	}

	public void setrRealizeNote(String rRealizeNote) {
		this.rRealizeNote = rRealizeNote;
	}

	public String gettDisposeNote() {
		return tDisposeNote;
	}

	public void settDisposeNote(String tDisposeNote) {
		this.tDisposeNote = tDisposeNote;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

}
