package com.potato.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.potato.dao.STaskRecordDao;
import com.potato.entity.STask;
import com.potato.entity.STaskRecord;
import com.potato.entity.SUser;
import com.potato.service.TaskRecordService;
@Service
@Transactional
public class TaskRecordServiceImpl extends BaseServiceImpl<STaskRecord> implements TaskRecordService {
	@Autowired 
	STaskRecordDao taskRecordDao;
	
	@Override
	Class<STaskRecord> getClassType() {
		return STaskRecord.class;
	}
	/**
	 * 根据任务获取任务记录对象
	 * @param task
	 * @return
	 */
	public STaskRecord getSTaskRecord(STask task) {
		STaskRecord record = new STaskRecord();
		record.setBranch(task.getBranch());
		record.setCreateTime(new Date());
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		SUser user = (SUser)request.getSession().getAttribute("user");
		if(user!=null) {
			record.setCreator(user.getUserName());
		}else {
			record.setCreator(task.getCreator());
		}
		record.setInfluence(task.getInfluence());
		record.setPriority(task.getPriority());
		record.setState(task.getState());
		record.setTaskId(task.getId());
		record.setWillFinishTime(task.getWillFinishTime());
		record.setModifierNote(task.getModifierNote());
		record.setVerifyNote(task.getVerifyNote());
		record.setrAnalyseNote(task.getrAnalyseNote());
		record.setrDesignNote(task.getrDesignNote());
		record.setrRealizeNote(task.getrRealizeNote());
		record.settDisposeNote(task.gettDisposeNote());
		record.setType(task.getType());
		return record;
	}
	
	/**
	 * 根据任务主键删除任务记录
	 */
	public int delSTaskRecord(String taskId) {
		return this.taskRecordDao.executeUpdate("delete from s_task_record where task_id = ?",taskId);
	}
	/**
	 * 根据任务主键获取任务记录信息集合
	 * @param taskId
	 * @return
	 */
	public List<STaskRecord> list(String taskId){
		return this.taskRecordDao.createQuery().andEq("task_id", taskId).desc("create_time").select();
	}
}
