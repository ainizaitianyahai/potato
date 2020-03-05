package com.potato.service.impl;

import java.util.List;

import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.potato.service.BaseService;

public abstract class BaseServiceImpl<T> implements BaseService<T>{
	@Autowired
	SQLManager sqlManager;
	
	abstract Class<T> getClassType();
	
	public BaseServiceImpl<T> getBaseServiceImpl() {
		return this;
	}
	/**
	 * 获取列表
	 * @param offset		分页参数--起始条目数
	 * @param pageSize		分页参数--查询多少条
	 * @return
	 */
	public List<T> list(int offset,int pageSize) {
		return sqlManager.all(getClassType(), offset, pageSize);
	}
	
	/**
	 * 获取列表
	 * @return
	 */
	public List<T> list() {
		return sqlManager.all(getClassType());
	}

	/**
	 * 获取列表
	 * @param start	起始条目
	 * @param size	查询条目
	 * @return
	 */
	public List<T> page(int start,int size) {
		return sqlManager.all(getClassType(), start, size);
	}
	/**
	 * 获取实例
	 * @param id
	 * @return
	 */
	public T get(String id) {
		return sqlManager.single(getClassType(), id);
	}
	/**
	 * 保存实例
	 * @param bean
	 */
	@Transactional
	public void insert(T bean) {
		sqlManager.insert(getClassType(), bean);
	}
	
	/**
	 * 修改实例
	 * @param bean
	 */
	@Transactional
	public void updateById(T bean) {
		sqlManager.updateById(bean);
	}
	
	/**
	 * 删除实例
	 * @param id	实例主键
	 * @return
	 */
	@Transactional
	public int del(String id) {
		return sqlManager.deleteById(getClassType(), id);
	}
	/**
	 * 实例总数
	 * @return 实例总数	
	 */
	public Long allCount() {
		return sqlManager.allCount(getClassType());
	}
	/**
	 * 判断是否唯一
	 * @param sqlColumn		判断数据库所属字段
	 * @param value			判断数据库所属值
	 * @param condition		查询条件
	 * @return string		true: 不存在 fales:存在
	 */
	public String unique(String sqlColumn,String value,String condition){
//		//组装查询条件
//		org.beetl.sql.core.query.Query<T> query = new org.beetl.sql.core.query.Query<>(sqlManager, getClassType());
//		//查询字段和值
//		query.andEq(sqlColumn, value);
//		if(condition!=null&&!"".equals(condition)) {
//			//json转换Map
//			Map<String,Object> map = JSON.parseObject(condition);  
//			//循环组装查询条件
//			for(Map.Entry<String, Object> e:map.entrySet()) {
//				query.andEq(e.getKey(), e.getValue());
//			}
//		}
//		//查询结果
//		List<T> list = query.select();
//		//判断是否存在
//		if(list!=null&&list.size()>0) {
//			return "false";
//		}else {
//			return "true";
//		}
		return null;
	}
	
	
}
