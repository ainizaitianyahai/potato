package com.potato.web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.potato.service.impl.BaseServiceImpl;

public abstract class BaseController{
	
	/**
	 * 跳转基础路径
	 */
	protected String path;
	/**
	 * 基础service
	 */
	protected BaseServiceImpl<?> baseServiceImpl;
	
	public abstract void setBaseServiceImpl();
	/**
	 * 验证数据唯一
	 * @param model		Model模型
	 * @return
	 */
	@RequestMapping("/unique")
	@ResponseBody
	public String unique(String paramName,String paramValue,String condition) {
		this.setBaseServiceImpl();
		return baseServiceImpl.unique(paramName, paramValue,condition);
	}
	/**
	 * 获取列表
	 * @param model		Model模型
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model) {
		this.setBaseServiceImpl();
		model.addAttribute("list",baseServiceImpl.list());
		return path+"/list";
	}
	/**
	 * 获取列表
	 * @param model		Model模型
	 * @return
	 */
	@RequestMapping("/page")
	public String page(Model model,int start,int size) {
		this.setBaseServiceImpl();
		model.addAttribute("list",baseServiceImpl.page(start, size));
		return path+"/page";
	}
	
	/**
	 * 删除
	 * @param model
	 * @param userId
	 * @return
	 */
	@RequestMapping("/del")
	public String del(Model model,String id) {
		this.setBaseServiceImpl();
		this.baseServiceImpl.del(id);
		return this.list(model);
	}
}
