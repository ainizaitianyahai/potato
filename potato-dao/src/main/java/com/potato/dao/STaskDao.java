package com.potato.dao;
import java.util.List;

import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.mapper.BaseMapper;

import com.potato.entity.STask;

/*
* 
* gen by beetlsql mapper 2019-01-30
*/
public interface STaskDao extends BaseMapper<STask> {
	
	/**
	 *  根据添加查询任务
	 * @param task
	 * @return
	 */
	public List<STask> search(@Param(value = "task") STask task);
	/**
	 *  根据添加查询任务
	 * @param task
	 * @return
	 */
	public List<STask> myTaskList(@Param(value = "userName") String userName,@Param(value = "task") STask task,@Param(value = "stateArray") String[] stateArray);
	
}
