package com.potato.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.potato.utils.DateFormatter;

@Controller
public class ErrorController extends AbstractErrorController {
	//异常请求链接
	private static final String ERROR_PATH = "/error";
	//log日志
	private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);
	@Autowired
	ObjectMapper objectMapper;
	
	public ErrorController(ErrorAttributes errorAttributes) {
		super(new DefaultErrorAttributes());
	}
	/**
	 * 统一异常处理方法
	 * @param request
	 * @param resonse
	 * @return
	 */
	@RequestMapping(ERROR_PATH)
	public ModelAndView getErrorPath(HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> model = Collections.unmodifiableMap(getErrorAttributes(request, false));
		//获取异常，有可能为空
		Throwable cause = getCause(request);
		//异常错误代号，对应于HTTP Status 如 404
		int status = (Integer)model.get("status");
		//错误信息
		String message = (String)model.get("message");
		//友好提示
		String errorMessage = getErrorMessage(cause);
		//后台打印日志信息，方便查错
		logger.info(status+","+message,cause);
		response.setStatus(status);
		//判断 人员登录校验失败，返回登录页面
		if(cause instanceof IncorrectCredentialsException) {
			ModelAndView view = new ModelAndView("/loginPage");
			view.addAllObjects(model);
			view.addObject("errorMessage","用户名或密码不对，请重新输入。");
			view.addObject("status",status);
			view.addObject("cause",cause);
			view.addObject("time", new Date());
			return view;
		}
		if(!isJsonRequest(request)) {
			ModelAndView view = new ModelAndView("/error");
			view.addAllObjects(model);
			view.addObject("errorMessage",errorMessage);
			view.addObject("status",status);
			view.addObject("cause",cause);
			view.addObject("time", new Date());
			return view;
		}else {
			Map<String,Object> error = new HashMap<String,Object>();
			error.put("success", false);
			error.put("errorMessage", errorMessage);
			error.put("message", message);
			error.put("time", DateFormatter.formatEsc(new Date()));
			writerJson(response, error);
			return null;
		}
	}
	/**
	 * 对象转换成JSON
	 * @param response
	 * @param obj
	 */
	protected final void writerJson(HttpServletResponse response,Object obj) { 
		response.setContentType("application/json;charset=utf-8"); 
		PrintWriter out = null; 
		try { 
			String str = JSON.toJSONString(obj);
			out = response.getWriter(); 
			out.println(str); 
		} catch (IOException e) { 
			e.printStackTrace(); 
		} finally { 
			if (out != null) { 
				out.flush(); 
				out.close(); 
			} 
		} 
	} 
	/**
	 * 获取应用系统异常
	 * @param request
	 * @return
	 */
	protected Throwable getCause(HttpServletRequest request) {
		Throwable error = (Throwable)request.getAttribute("javax.servlet.error.exception");
		if(error != null) {
			//MVC有可能会封装异常成ServletException，需要调用getCasuse获取真正的异常
			while(error instanceof ServletException && error.getCause() != null) {
				error = ((ServletException)error).getCause();
			}
		}
		return error;
	}
	/**
	 * 返回异常信息
	 * @param ex
	 * @return
	 */
	protected String getErrorMessage(Throwable ex) {
		return "服务器异常，请联系管理员。";
	}
	/**
	 * 区分客户端发起的是页面请求还是JSON请求
	 * @param request
	 * @return
	 */
	protected boolean isJsonRequest(HttpServletRequest request) {
		String requestUri = (String)request.getAttribute("javax.servlet.error.request_uri");
		if(requestUri != null && requestUri.endsWith("Json")) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public String getErrorPath() {
		return null;
	}

}
