package com.potato.web.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.potato.entity.SUser;
import com.potato.utils.JwtUtils;

@Controller
public class LoginController {
	 
	@RequestMapping("/login")
    public String login() {
        return "loginPage";
    }

    @RequestMapping("/loginUser")
    public String loginUser(String logname,String logpass,HttpSession session,RedirectAttributes attr) {
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(logname,logpass);
        Subject subject = SecurityUtils.getSubject();
        subject.login(usernamePasswordToken);   //完成登录
        SUser user=(SUser) subject.getPrincipal();
        String token = JwtUtils.createToken(logname);
        session.setAttribute("user", user);
        attr.addAttribute("token",token);
        return "redirect:index";
    }
    
    @RequestMapping("/logout")
    public String logOut(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "loginPage";
    }
    @RequestMapping("/skin")
    @ResponseBody
    public String skin(HttpSession session,String huiskin) {
    	session.setAttribute("huiskin", huiskin);
        return "success";
    }
    
    @RequestMapping("/index")
    public String index(ServletRequest request,RedirectAttributes attr) {
    	attr.addAttribute("token",request.getAttribute("token"));
		return "redirect:task/myTaskList";
	}
}
