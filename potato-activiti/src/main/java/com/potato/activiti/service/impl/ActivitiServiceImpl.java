package com.potato.activiti.service.impl;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationHome;
import org.springframework.stereotype.Service;

import com.potato.activiti.dao.VActReProcdefDao;
import com.potato.activiti.entity.VActReProcdef;
import com.potato.activiti.service.ActivitiService;
	
/**
 * 工作流业务类
 * @author ghw
 *
 */
@Service
public class ActivitiServiceImpl implements ActivitiService{
	//log日志
	private static final Logger log = LoggerFactory.getLogger(ActivitiServiceImpl.class);
	@Autowired
    private RepositoryService repositoryService;
	@Autowired  
    private RuntimeService runtimeService;  
	@Autowired  
	private TaskService taskService; 
	@Autowired  
	private HistoryService historyService; 
	@Autowired
	private VActReProcdefDao varfDao;
	 
	
	private final static String processesPath = "processes";
	
	public List<String> list(){
		//获取文件的路径，兼容模块化
		ApplicationHome home = new ApplicationHome(getClass());
		String path = home.getSource()+"\\"+processesPath;
		log.info("所有工作流路径："+path);
		File directory = new File(path);
		//是文件夹
		if(directory.isDirectory()) {
			//获取文件夹下的文件
			File[] list = directory.listFiles();
			for (File file : list) {
				//是文件
				if(file.isFile()&&file.getName().indexOf("bpmn")>-1) {
					System.out.println(file.getName());
				}
			}
		}
		return null;
	}
	
	
	
	public void deploymentAll() {
		log.info("部署所有工作流");
		//获取一个部署构建器对象，用于加载流程定义文件
		DeploymentBuilder builder = repositoryService.createDeployment();
		//获取文件的路径，兼容模块化
		ApplicationHome home = new ApplicationHome(getClass());
		String path = home.getSource()+"\\"+processesPath;
		log.info("部署所有工作流路径："+path);
		File directory = new File(path);
		//是文件夹
		if(directory.isDirectory()) {
			//获取文件夹下的文件
			File[] list = directory.listFiles();
			for (File file : list) {
				//是文件
				if(file.isFile()) {
					//加载流程定义文件
					builder.addClasspathResource(processesPath+"/"+file.getName());
					log.info("工作流路径："+processesPath+"/"+file.getName());
				}
			}
		}
		//部署流程定义	
		builder.deploy();
		log.info("部署完成");
	}
	
	
	public void deployment(String name) {
		log.info("部署名称为："+name+"的工作流");
		//获取一个部署构建器对象，用于加载流程定义文件
		DeploymentBuilder builder = repositoryService.createDeployment();
		//加载流程定义文件
		builder.addClasspathResource(processesPath+"/"+name+".bpmn");
		builder.addClasspathResource(processesPath+"/"+name+".png");
		//部署流程定义	
		builder.deploy();
		log.info("部署完成");
	}
	
	
	public List<Deployment> getDeploymentList() {
		List<Deployment> list = repositoryService.createDeploymentQuery().list();
		return list;
	}
	
	
	public List<ProcessDefinition> getProcessDefinitionList() {
		ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();
		List<ProcessDefinition> list = query.list();
		return list;
	}
	
	public List<VActReProcdef> getVActReProcdefList() {
		return varfDao.all();
	}
	
	public void delDeployment(String deploymentId) {
		//级联删除工作流实例
		repositoryService.deleteDeployment(deploymentId,true);
	}
	
	
	public void startProcess(String key) {
		this.startProcess(key, null);
	}
	
	public void startProcess(String key,Map<String, Object> variables) {
		ProcessInstance processInstance = null;
		if(variables!=null) {
			processInstance = runtimeService.startProcessInstanceByKey(key,variables);
		}else {
			processInstance = runtimeService.startProcessInstanceByKey(key);
		}
		
		System.out.println(processInstance.getId());
	}
	
	public List<ProcessInstance> processList() {
		ProcessInstanceQuery query = runtimeService.createProcessInstanceQuery();
		return query.list();
	}
	
	
	
	
	public void submitProcess(String taskId) {
		taskService.complete(taskId);
	}
	
	
	public void delProcess(String processInstanceId){
		runtimeService.deleteProcessInstance(processInstanceId , "强制结束");
	}
	
	
	public void taskList(String assignee) {
		TaskQuery query = taskService.createTaskQuery();
		query.taskAssignee(assignee);
		query.orderByTaskCreateTime().desc();
		List<Task> list = query.list();
		for(Task task:list) {
			System.out.println(task.getId());
		}
	}
	
	
	public List<HistoricProcessInstance> histProcessList(){
		HistoricProcessInstanceQuery query = historyService.createHistoricProcessInstanceQuery();
		return query.list();
	}
	
	
	public List<HistoricActivityInstance> histActivityList(String processInstanceId){
		HistoricActivityInstanceQuery query = historyService.createHistoricActivityInstanceQuery();
		query.processInstanceId(processInstanceId);
		query.orderByHistoricActivityInstanceEndTime().asc();
		return query.list();
	}
	
	
	public List<HistoricTaskInstance> histTaskList(String processInstanceId){
		HistoricTaskInstanceQuery query = historyService.createHistoricTaskInstanceQuery();
		query.processInstanceId(processInstanceId);
		query.orderByHistoricTaskInstanceEndTime().asc();
		return query.list();
	}
}
