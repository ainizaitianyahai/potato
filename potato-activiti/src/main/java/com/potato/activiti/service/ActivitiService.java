package com.potato.activiti.service;

import java.util.List;
import java.util.Map;

import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

import com.potato.activiti.entity.VActReProcdef;

/**
 * 工作流业务接口
 * @author ghw
 *
 */
public interface ActivitiService {
	/**
	 * 部署所有流程
	 */
	public void deploymentAll();
	/**
	 * 部署单个流程
	 * @param name	流程名称
	 */
	public void deployment(String name);
	/**
	 * 查询部署列表
	 * @return
	 */
	public List<Deployment> getDeploymentList();
	/**
	 * 查询流程定义列表
	 */
	public List<ProcessDefinition> getProcessDefinitionList();
	/**
	 * 查询最新版本的流程定义列表
	 * @return
	 */
	public List<VActReProcdef> getVActReProcdefList() ;
	/**
	 * 删除部署信息
	 * @param deploymentId	部署信息主键
	 */
	public void delDeployment(String deploymentId);
	/**
	 * 根据流程key启动流程实例
	 * @param key		流程图 process节点的id
	 */
	public void startProcess(String key);
	/**
	 * 根据流程key启动流程实例
	 * @param key			流程图 process节点的id
	 * @param variables		流程变量Map
	 */
	public void startProcess(String key,Map<String, Object> variables);
	/**
	 * 删除流程实例
	 * @param processInstanceId	流程实例Id
	 */
	public void delProcess(String processInstanceId);
	/**
	 * 流程实例列表
	 * @return
	 */
	public List<ProcessInstance> processList();
	/**
	 * 根据条件查询流程任务列表
	 * @param assignee		人员Id
	 */
	public void taskList(String assignee);
	/**
	 * 提交指定流程任务
	 * @param taskId	任务主键
	 */
	public void submitProcess(String taskId);
	/**
	 * 历史流程实例列表
	 */
	public List<HistoricProcessInstance> histProcessList();
	/**
	 * 历史活动数据
	 * @param processDefinitionId	流程实例Id
	 * @return
	 */
	public List<HistoricActivityInstance> histActivityList(String processInstanceId);
	/**
	 * 历史任务数据
	 * @param processInstanceId	流程实例Id
	 * @return
	 */
	public List<HistoricTaskInstance> histTaskList(String processInstanceId);
}
