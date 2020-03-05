package com.potato.service;

import java.util.List;

import com.potato.entity.STask;


public interface TaskService extends BaseService<STask>{
	/**
	 * 根据添加查询任务
	 * @param task
	 * @return
	 */
	public List<STask> list(STask task);
	/**
	 * 获取人员相关的任务
	 * @param userName
	 * @return
	 */
	public List<STask> myTask(String userName,STask task);
	/**
	 * 撤销任务
	 * @param id
	 */
	public void cancel(String id);
	/**
	 * 公用更改任务方法
	 * @param task
	 */
	public void update(STask task);
}
