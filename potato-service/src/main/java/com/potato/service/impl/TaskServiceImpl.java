package com.potato.service.impl;

import com.potato.dao.STaskDao;
import com.potato.entity.STask;
import com.potato.entity.STaskRecord;
import com.potato.service.TaskRecordService;
import com.potato.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
@Transactional
public class TaskServiceImpl extends BaseServiceImpl<STask> implements TaskService {
	@Autowired 
	STaskDao taskDao;
	@Autowired
	TaskRecordService taskRecordService;
	@Override
	Class<STask> getClassType() {
		return STask.class;
	}
	
	/**
	 * 根据添加查询任务
	 * @param task
	 * @return
	 */
	public List<STask> list(STask task){
		return this.taskDao.search(task);
	}
	
	public void insert(STask task) {
		//创建时间
		task.setCreateTime(new Date());
		task.setProject("OnRoad");
		this.taskDao.insert(task, true);
		if(!"草稿".equals(task.getState())) {
			STaskRecord record = this.taskRecordService.getSTaskRecord(task);
			this.taskRecordService.insert(record);
		}
	}
	
	public void updateById(STask task) {
		if(!"草稿".equals(task.getState())) {
			//判断是否不存储任务修改记录 true:不存储，false:存储
			String saveRecord = task.getSaveRecord();
			if(saveRecord==null||"".equals(saveRecord)||"false".equals(saveRecord)) {	
				STaskRecord record = this.taskRecordService.getSTaskRecord(task);
				this.taskRecordService.insert(record);
			}
		}
		this.taskDao.updateById(task);
	}
	/**
	 * 获取人员相关的任务
	 * @param userName
	 * @return
	 */
	public List<STask> myTask(String userName,STask task) {
		String[] stateArray = new String[7];
		stateArray[0] = "分析中";
		stateArray[1] = "解决中";
		stateArray[2] = "已解决";
		stateArray[3] = "分析中";
		stateArray[4] = "设计中";
		stateArray[5] = "实现中";
		stateArray[6] = "已发布";
		return this.taskDao.myTaskList(userName, task,stateArray);
	}
	/**
	 * 撤销任务
	 * @param id
	 */
	public void cancel(String id) {
		STask task = this.taskDao.single(id);
		task.setState("草稿");
		STaskRecord record = this.taskRecordService.getSTaskRecord(task);
		this.taskRecordService.insert(record);
		this.taskDao.updateById(task);
	}
	/**
	 * 删除任务及删除任务相关的任务记录
	 */
	public int del(String id) {
		this.taskRecordService.delSTaskRecord(id);
		return taskDao.deleteById(id);
	}
	/**
	 * 公用更改任务方法
	 * @param task
	 */
	public void update(STask task) {
		//判断是否不存储任务修改记录 true:不存储，false:存储
		String saveRecord = task.getSaveRecord();
		if(saveRecord==null||"".equals(saveRecord)||"false".equals(saveRecord)) {	
			STaskRecord record = this.taskRecordService.getSTaskRecord(task);
			this.taskRecordService.insert(record);
		}
		STask task_p = this.taskDao.single(task.getId());
		task.setCreator(task_p.getCreator());
		task.setCreatorId(task_p.getCreatorId());
		this.taskDao.updateById(task);
	}
}
