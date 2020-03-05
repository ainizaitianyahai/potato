package com.potato.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.potato.entity.SUser;
import com.potato.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/user")
@Api(tags="用户类",value="用户类")
public class UserController extends BaseController{
	@Autowired
	UserService userService;
	@Override
	public void setBaseServiceImpl() {
		this.path = "user";
		this.baseServiceImpl = userService.getBaseServiceImpl();
	}
	/**
	 * 获取人员信息
	 * @return
	 */
	@ApiOperation(value="获取用户列表", notes="获取用户列表",httpMethod="GET")
	@RequestMapping(value = {"/listJson"}, produces="application/json;charset=UTF-8")
	@ResponseBody
	public String listJson() {
		List<SUser> list = this.userService.list();
		return JSON.toJSONString(list);
	}
	
	/**
	 * 新建人员
	 * @return
	 */
	@ApiOperation(value="新建用户", notes="新建用户",httpMethod="GET")
	@RequestMapping(value = {"/add"}, produces="application/json;charset=UTF-8")
	public String add() {
		return "user/add";
	}
	
	@RequestMapping(value = {"/saveJson"}, produces="application/json;charset=UTF-8")
	@ResponseBody
    public String saveJson(@Valid SUser user, BindingResult result) {
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
		this.userService.insert(user);
		return "{\"msg\":\"success\"}";
    }
	@RequestMapping("/edit")
    public String edit(Model model,String id) {
		SUser user = this.userService.get(id);
		model.addAttribute("user",user);
		return "user/edit";
    }
	@RequestMapping(value = {"/updateJson"}, produces="application/json;charset=UTF-8")
	@ResponseBody
    public String update(@Valid SUser user, BindingResult result) {
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
		 this.userService.updateById(user);
		return "{\"msg\":\"success\"}";
    }
	
	@RequestMapping("/del")
    public String del(Model model,String id) {
		this.userService.del(id);
		return this.list(model);
    }
	
}
