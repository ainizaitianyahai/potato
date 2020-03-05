package com.potato.entity;
import java.util.Date;

import org.beetl.sql.core.annotatoin.AutoID;
import org.hibernate.validator.constraints.NotBlank;

/* 
* 
* gen by beetlsql 2019-01-30
*/
public class STask  {
	
	//主键
	@AutoID
	private Integer id ;
	//父节点Id
	private Integer parentId ;
	//优先级
	private Integer priority ;
	//分析人
	@NotBlank(message="分析人不能为空。")
	private String analyst ;
	//影响分支
	private String branch ;
	//关闭人
	private String closer ;
	//创建人
	private String creator ;
	//说明
	private String explain ;
	//修改人
	private String modifier ;
	//软件项目
	private String project ;
	//提出人
	private String proposer ;
	//来源
	private String source ;
	//状态
	private String state ;
	//任务编号
	private String code ;
	//类型：问题、需求、任务
	private String type ;
	//验证人
	private String verify ;
	//创建时间
	private Date createTime ;
	//计划完成时间
	private Date willFinishTime ;
	//影响域
	private String influence;	
	//更改说明
	private String modifierNote;	
	//验证说明
	private String verifyNote;	
	
	//需求分析人员
	private String rAnalyse;
	//需求分析说明
	private String rAnalyseNote;
	//需求设计人员
	private String rDesign;
	//需求设计说明
	private String rDesignNote;
	//需求实现人员
	private String rRealize;
	//需求实现说明
	private String rRealizeNote;
	//任务处理人员
	private String tDispose;
	//任务处理说明
	private String tDisposeNote;
	
	//创建人id
	private String creatorId;
	//分析人id
	private String analystId;
	//修改人id
	private String modifierId;
	//验证人id
	private String verifyId;
	//关闭人id
	private String closeId;
	//需求分析人员Id
	private String rAnalyseId;
	//需求设计人员Id
	private String rDesignId;
	//需求实现人员Id
	private String rRealizeId;
	//任务处理人员Id
	private String tDisposeId;
	
	//开始时间	临时变量 数据库不存储
	private Date beginDate;
	//结束时间	临时变量 数据库不存储
	private Date endDate;
	//是否不存储修改记录	临时变量 数据库不存储
	private String saveRecord;
	
	public STask() {
	}
	
	/**主键
	*@return 
	*/
	public Integer getId(){
		return  id;
	}
	/**主键
	*@param  id
	*/
	public void setId(Integer id ){
		this.id = id;
	}
	/**父节点Id
	*@return 
	*/
	public Integer getParentId(){
		return  parentId;
	}
	/**父节点Id
	*@param  parentId
	*/
	public void setParentId(Integer parentId ){
		this.parentId = parentId;
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
	
	/**分析人
	*@return 
	*/
	public String getAnalyst(){
		return  analyst;
	}
	/**分析人
	*@param  analyst
	*/
	public void setAnalyst(String analyst ){
		this.analyst = analyst;
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
	
	/**关闭人
	*@return 
	*/
	public String getCloser(){
		return  closer;
	}
	/**关闭人
	*@param  closer
	*/
	public void setCloser(String closer ){
		this.closer = closer;
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
	
	/**说明
	*@return 
	*/
	public String getExplain(){
		return  explain;
	}
	/**说明
	*@param  explain
	*/
	public void setExplain(String explain ){
		this.explain = explain;
	}
	
	/**修改人
	*@return 
	*/
	public String getModifier(){
		return  modifier;
	}
	/**修改人
	*@param  modifier
	*/
	public void setModifier(String modifier ){
		this.modifier = modifier;
	}
	
	/**软件项目
	*@return 
	*/
	public String getProject(){
		return  project;
	}
	/**软件项目
	*@param  project
	*/
	public void setProject(String project ){
		this.project = project;
	}
	
	/**提出人
	*@return 
	*/
	public String getProposer(){
		return  proposer;
	}
	/**提出人
	*@param  proposer
	*/
	public void setProposer(String proposer ){
		this.proposer = proposer;
	}
	
	/**来源
	*@return 
	*/
	public String getSource(){
		return  source;
	}
	/**来源
	*@param  source
	*/
	public void setSource(String source ){
		this.source = source;
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
	public String getCode(){
		return  code;
	}
	/**任务编号
	*@param  code
	*/
	public void setCode(String code ){
		this.code = code;
	}
	
	/**类型：问题、需求、任务
	*@return 
	*/
	public String getType(){
		return  type;
	}
	/**类型：问题、需求、任务
	*@param  type
	*/
	public void setType(String type ){
		this.type = type;
	}
	
	/**验证人
	*@return 
	*/
	public String getVerify(){
		return  verify;
	}
	/**验证人
	*@param  verify
	*/
	public void setVerify(String verify ){
		this.verify = verify;
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

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getInfluence() {
		return influence;
	}

	public void setInfluence(String influence) {
		this.influence = influence;
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

	public String getrAnalyse() {
		return rAnalyse;
	}

	public void setrAnalyse(String rAnalyse) {
		this.rAnalyse = rAnalyse;
	}

	public String getrAnalyseNote() {
		return rAnalyseNote;
	}

	public void setrAnalyseNote(String rAnalyseNote) {
		this.rAnalyseNote = rAnalyseNote;
	}

	public String getrDesign() {
		return rDesign;
	}

	public void setrDesign(String rDesign) {
		this.rDesign = rDesign;
	}

	public String getrDesignNote() {
		return rDesignNote;
	}

	public void setrDesignNote(String rDesignNote) {
		this.rDesignNote = rDesignNote;
	}

	public String getrRealize() {
		return rRealize;
	}

	public void setrRealize(String rRealize) {
		this.rRealize = rRealize;
	}

	public String getrRealizeNote() {
		return rRealizeNote;
	}

	public void setrRealizeNote(String rRealizeNote) {
		this.rRealizeNote = rRealizeNote;
	}

	public String gettDispose() {
		return tDispose;
	}

	public void settDispose(String tDispose) {
		this.tDispose = tDispose;
	}

	public String gettDisposeNote() {
		return tDisposeNote;
	}

	public void settDisposeNote(String tDisposeNote) {
		this.tDisposeNote = tDisposeNote;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getAnalystId() {
		return analystId;
	}

	public void setAnalystId(String analystId) {
		this.analystId = analystId;
	}

	public String getModifierId() {
		return modifierId;
	}

	public void setModifierId(String modifierId) {
		this.modifierId = modifierId;
	}

	public String getVerifyId() {
		return verifyId;
	}

	public void setVerifyId(String verifyId) {
		this.verifyId = verifyId;
	}

	public String getCloseId() {
		return closeId;
	}

	public void setCloseId(String closeId) {
		this.closeId = closeId;
	}

	public String getrAnalyseId() {
		return rAnalyseId;
	}

	public void setrAnalyseId(String rAnalyseId) {
		this.rAnalyseId = rAnalyseId;
	}

	public String getrDesignId() {
		return rDesignId;
	}

	public void setrDesignId(String rDesignId) {
		this.rDesignId = rDesignId;
	}

	public String getrRealizeId() {
		return rRealizeId;
	}

	public void setrRealizeId(String rRealizeId) {
		this.rRealizeId = rRealizeId;
	}

	public String gettDisposeId() {
		return tDisposeId;
	}

	public void settDisposeId(String tDisposeId) {
		this.tDisposeId = tDisposeId;
	}

	public String getSaveRecord() {
		return saveRecord;
	}

	public void setSaveRecord(String saveRecord) {
		this.saveRecord = saveRecord;
	}

	
	
}
