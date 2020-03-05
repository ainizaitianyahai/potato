package com.potato.activiti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.potato.activiti.service.ActivitiService;

@RestController  
@RequestMapping("/activiti")
public class ActivityController {
    @Autowired
    private ActivitiService activitiService;
    
    @RequestMapping("/deploymentAll")  
    @ResponseBody
    public String deploymentAll() {
    	activitiService.deploymentAll();
    	return "成功";
    }
    @RequestMapping("/deployment")  
    @ResponseBody
    public String deployment(String name) {
    	activitiService.deployment(name);
    	return "成功";
    }
    @RequestMapping("/delDeployment")  
    @ResponseBody
    public String delDeployment(String id) {
    	activitiService.delDeployment(id);
    	return "删除成功";
    }
    @RequestMapping("/startProcess")  
    @ResponseBody
    public String startProcess(String key) {
    	activitiService.startProcess(key);
    	return "成功";
    }
    @RequestMapping("/taskList")  
    @ResponseBody
    public String taskList(String assignee) {
    	activitiService.taskList(assignee);
    	return "流程任务查询成功";
    }
    @RequestMapping("/submitProcess")  
    @ResponseBody
    public String submitProcess(String taskId) {
    	activitiService.submitProcess(taskId);
    	return "流程任务办理成功";
    }
    @RequestMapping("/processDefinitionList")  
    @ResponseBody
    public String getProcessDefinitionList() {
    	return JSON.toJSONString(activitiService.getProcessDefinitionList());
    }
    @RequestMapping("/vActReProcdefList")  
    @ResponseBody
    public String getVActReProcdefList() {
    	return JSON.toJSONString(activitiService.getVActReProcdefList());
    }
    
}
