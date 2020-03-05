package com.potato.web.controller;

import com.potato.entity.STask;
import com.potato.entity.SUser;
import com.potato.service.TaskRecordService;
import com.potato.service.TaskService;
import com.potato.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/task")
public class TaskController extends BaseController{
	@Autowired
	TaskService taskService;
	@Autowired
	UserService userService;
	@Autowired
	TaskRecordService taskRecordService;
	@Override
	public void setBaseServiceImpl() {
		this.path = "task";
		this.baseServiceImpl = taskService.getBaseServiceImpl();
	}
	
	@RequestMapping("/add")
    public String add(Model model) {
		model.addAttribute("userlist",userService.list());
		model.addAttribute("now",new Date());
		return "task/add";
    }
	
	@RequestMapping(value = {"/saveJson"}, produces="application/json;charset=UTF-8")
	@ResponseBody
    public String save(@Valid STask task, BindingResult result) {
		 if (result.hasErrors()) {
	            result.getAllErrors().forEach((error) -> {
	                FieldError fieldError = (FieldError) error;
	                // 属性
	                String field = fieldError.getField();
	                // 错误信息
	                String message = fieldError.getDefaultMessage();
	                System.out.println(field + ":" + message);
	            });

	        }
		taskService.insert(task);
		return "{\"msg\":\"success\"}";
    }
	
	@RequestMapping(value = {"/updateJson"}, produces="application/json;charset=UTF-8")
	@ResponseBody
    public String update(@Valid STask task, BindingResult result) {
		 if (result.hasErrors()) {
	            result.getAllErrors().forEach((error) -> {
	                FieldError fieldError = (FieldError) error;
	                // 属性
	                String field = fieldError.getField();
	                // 错误信息
	                String message = fieldError.getDefaultMessage();
	                System.out.println(field + ":" + message);
	            });

	        }
		taskService.updateById(task);
		return "{\"msg\":\"success\"}";
    }
	
	@RequestMapping("/del")
    public String del(Model model,String id) {
		this.taskService.del(id);
		return this.list(model);
    }
	
	@RequestMapping("/cancel")
    public String cancel(Model model,String id) {
		this.taskService.cancel(id);
		return this.list(model);
    }
	
	@RequestMapping("/edit")
    public String edit(Model model,String id) {
		STask task = this.taskService.get(id);
		model.addAttribute("task",task);
		model.addAttribute("userlist",userService.list());
		return "task/edit";
    }
	
	@RequestMapping("/view")
    public String view(Model model,String id) {
		STask task = this.taskService.get(id);
		model.addAttribute("task",task);
		model.addAttribute("recordList",taskRecordService.list(id));
		return "task/view";
    }
	/**
	 * 获取列表
	 * @param model		Model模型
	 * @return
	 */
	@RequestMapping("/search")
	public String search(Model model,STask task) {
		model.addAttribute("list",taskService.list(task));
		model.addAttribute("task",task);
		return "task/list";
	}
	
	/**
	 * 获取列表
	 * @param model		Model模型
	 * @return
	 */
	@RequestMapping("/myTaskList")
	public String myTaskList(Model model,HttpSession session,STask task) {
		SUser user = (SUser)session.getAttribute("user");
		model.addAttribute("list",taskService.myTask(user.getUserName(),task));
		model.addAttribute("task",task);
		return "task/myTaskList";
	}
	/**
	 * 分析任务
	 * @param model		Model模型
	 * @return
	 */
	@RequestMapping("/analyse")
	public String analyse(Model model,String id) {
		STask task = this.taskService.get(id);
		model.addAttribute("task",task);
		model.addAttribute("recordList",taskRecordService.list(id));
		model.addAttribute("userlist",userService.list());
		return "task/analyseBug";
    }
	/**
	 * 解决任务
	 * @param model		Model模型
	 * @return
	 */
	@RequestMapping("/modifier")
	public String modifier(Model model,String id) {
		STask task = this.taskService.get(id);
		model.addAttribute("task",task);
		model.addAttribute("recordList",taskRecordService.list(id));
		model.addAttribute("userlist",userService.list());
		return "task/modifierBug";
    }
	/**
	 * 验证任务
	 * @param model		Model模型
	 * @return
	 */
	@RequestMapping("/verify")
	public String verify(Model model,String id) {
		STask task = this.taskService.get(id);
		model.addAttribute("task",task);
		model.addAttribute("recordList",taskRecordService.list(id));
		model.addAttribute("userlist",userService.list());
		return "task/verifyBug";
    }
	/**
	 * 修改任务
	 * @param task
	 * @param result
	 * @return
	 */
	@RequestMapping(value = {"/updateMyTaskJson"}, produces="application/json;charset=UTF-8")
	@ResponseBody
    public String saveJson(@Valid STask task, BindingResult result) {
		 if (result.hasErrors()) {
	            result.getAllErrors().forEach((error) -> {
	                FieldError fieldError = (FieldError) error;
	                // 属性
	                String field = fieldError.getField();
	                // 错误信息
	                String message = fieldError.getDefaultMessage();
	                System.out.println(field + ":" + message);
	            });

	        }
		taskService.update(task);
		return "{\"msg\":\"success\"}";
    }
	/**
	 * 需求分析
	 * @param model		Model模型
	 * @return
	 */
	@RequestMapping("/requirementAnalyse")
	public String requirementAnalyse(Model model,String id) {
		STask task = this.taskService.get(id);
		model.addAttribute("task",task);
		model.addAttribute("recordList",taskRecordService.list(id));
		model.addAttribute("userlist",userService.list());
		return "task/requirementAnalyse";
    }
	
	/**
	 * 需求设计
	 * @param model		Model模型
	 * @return
	 */
	@RequestMapping("/requirementDesign")
	public String requirementDesign(Model model,String id) {
		STask task = this.taskService.get(id);
		model.addAttribute("task",task);
		model.addAttribute("recordList",taskRecordService.list(id));
		model.addAttribute("userlist",userService.list());
		return "task/requirementDesign";
    }
	
	/**
	 * 需求实现
	 * @param model		Model模型
	 * @return
	 */
	@RequestMapping("/requirementRealize")
	public String requirementRealize(Model model,String id) {
		STask task = this.taskService.get(id);
		model.addAttribute("task",task);
		model.addAttribute("recordList",taskRecordService.list(id));
		model.addAttribute("userlist",userService.list());
		return "task/requirementRealize";
    }
	
	/**
	 * 任务处理
	 * @param model		Model模型
	 * @return
	 */
	@RequestMapping("/disposeTask")
	public String disposeTask(Model model,String id) {
		STask task = this.taskService.get(id);
		model.addAttribute("task",task);
		model.addAttribute("recordList",taskRecordService.list(id));
		model.addAttribute("userlist",userService.list());
		return "task/disposeTask";
    }
	
}
