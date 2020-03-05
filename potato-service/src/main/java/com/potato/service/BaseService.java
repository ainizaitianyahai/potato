package com.potato.service;

import com.potato.service.impl.BaseServiceImpl;

import java.util.List;

public interface BaseService<T> {
	/**
	 * 获取基础接口
	 * @return
	 */
	public BaseServiceImpl<T> getBaseServiceImpl();
	
	/**
	 * 获取列表
	 * @param offset		分页参数--起始条目数
	 * @param pageSize		分页参数--查询多少条
	 * @return
	 */
	public List<T> list(int offset,int pageSize) ;
	/**
	 * 获取列表
	 * @return
	 */
	public List<T> list() ;
	/**
	 * 获取列表
	 * @param start	起始条目
	 * @param size	查询条目
	 * @return
	 */
	public List<T> page(int start,int size);
	/**
	 * 获取实例
	 * @param id
	 * @return
	 */
	public T get(String id) ;
	/**
	 * 保存实例
	 * @param bean
	 */
	public void insert(T bean) ;
	
	/**
	 * 修改实例
	 * @param bean
	 */
	public void updateById(T bean) ;
	
	/**
	 * 删除实例
	 * @param id	实例主键
	 * @return
	 */
	public int del(String id);
	/**
	 * 实例总数
	 * @return 实例总数	
	 */
	public Long allCount();
	
	
}
