package com.potato.service;

import java.util.List;

import com.potato.entity.STask;
import com.potato.entity.STaskRecord;

public interface TaskRecordService  extends BaseService<STaskRecord>{
	/**
	 * 根据任务获取任务记录对象
	 * @param task
	 * @return
	 */
	public STaskRecord getSTaskRecord(STask task);
	
	/**
	 * 根据任务主键删除任务记录
	 */
	public int delSTaskRecord(String taskId);
	/**
	 * 根据任务主键获取任务记录信息集合
	 * @param taskId
	 * @return
	 */
	public List<STaskRecord> list(String taskId);
}
