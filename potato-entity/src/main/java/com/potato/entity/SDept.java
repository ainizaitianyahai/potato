package com.potato.entity;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;

/* 
* 
* gen by beetlsql 2019-01-28
*/
public class SDept  {
	
	//主键
	private Integer id ;
	//部门名称
	private String deptName ;
	//父节点主键
	private String parentId ;
	//状态
	private String status ;
	
	public SDept() {
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
	
	/**部门名称
	*@return 
	*/
	public String getDeptName(){
		return  deptName;
	}
	/**部门名称
	*@param  deptName
	*/
	public void setDeptName(String deptName ){
		this.deptName = deptName;
	}
	
	/**父节点主键
	*@return 
	*/
	public String getParentId(){
		return  parentId;
	}
	/**父节点主键
	*@param  parentId
	*/
	public void setParentId(String parentId ){
		this.parentId = parentId;
	}
	
	/**状态
	*@return 
	*/
	public String getStatus(){
		return  status;
	}
	/**状态
	*@param  status
	*/
	public void setStatus(String status ){
		this.status = status;
	}
	

}
