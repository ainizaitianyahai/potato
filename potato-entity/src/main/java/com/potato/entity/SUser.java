package com.potato.entity;
import java.io.Serializable;
import java.util.Date;

import org.beetl.sql.core.annotatoin.AutoID;

/* 
* 
* gen by beetlsql 2019-01-28
*/
public class SUser  implements Serializable{
	
	//主键
	@AutoID
	private Integer id ;
	//所属部门
	private Integer deptId ;
	//身份证号
	private String cardId ;
	//密码
	private String password ;
	//手机号
	private String phone ;
	//状态
	private String state ;
	//人员登录名称
	private String userId ;
	//人员姓名
	private String userName ;
	//出生日期
	private Date birthdate ;
	
	public SUser() {
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
	
	/**所属部门
	*@return 
	*/
	public Integer getDeptId(){
		return  deptId;
	}
	/**所属部门
	*@param  deptId
	*/
	public void setDeptId(Integer deptId ){
		this.deptId = deptId;
	}
	
	/**身份证号
	*@return 
	*/
	public String getCardId(){
		return  cardId;
	}
	/**身份证号
	*@param  cardId
	*/
	public void setCardId(String cardId ){
		this.cardId = cardId;
	}
	
	/**密码
	*@return 
	*/
	public String getPassword(){
		return  password;
	}
	/**密码
	*@param  password
	*/
	public void setPassword(String password ){
		this.password = password;
	}
	
	/**手机号
	*@return 
	*/
	public String getPhone(){
		return  phone;
	}
	/**手机号
	*@param  phone
	*/
	public void setPhone(String phone ){
		this.phone = phone;
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
	
	/**人员登录名称
	*@return 
	*/
	public String getUserId(){
		return  userId;
	}
	/**人员登录名称
	*@param  userId
	*/
	public void setUserId(String userId ){
		this.userId = userId;
	}
	
	/**人员姓名
	*@return 
	*/
	public String getUserName(){
		return  userName;
	}
	/**人员姓名
	*@param  userName
	*/
	public void setUserName(String userName ){
		this.userName = userName;
	}
	
	/**出生日期
	*@return 
	*/
	public Date getBirthdate(){
		return  birthdate;
	}
	/**出生日期
	*@param  birthdate
	*/
	public void setBirthdate(Date birthdate ){
		this.birthdate = birthdate;
	}
	

}
