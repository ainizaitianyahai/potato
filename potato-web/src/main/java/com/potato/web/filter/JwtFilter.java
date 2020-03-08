package com.potato.web.filter;
import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.AntPathMatcher;

import com.potato.utils.JwtUtils;

import io.jsonwebtoken.Claims;
/**
 * JWT过滤器
 */
public class JwtFilter implements Filter {
    private static final org.springframework.util.PathMatcher pathMatcher = new AntPathMatcher();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    	
    }
    
	@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 // 不受保护的连接
		String[] urls = new String[] {"/","/login","/loginUser","/static/**","/api/**","/error"};
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String spath = httpRequest.getServletPath();
		//记录是否是不经过jwt鉴权的连接,默认经过鉴权验证
		boolean flag = false;
        // 不受保护的连接
        for (String url : urls) {
        	//判断是否是不受保护的连接，并记录不做jwt鉴权
            if (pathMatcher.match(url, spath)) {
            	flag = true;
            	break;
            }
        }
        if(flag) {	//不做jwt鉴权
        	chain.doFilter(request, response);
            return;
        }else {//jwt鉴权
        	HttpServletResponse httpResponse = (HttpServletResponse) response;
            String token = request.getParameter("token");
            //jwt鉴权,验证token
            Claims claims = JwtUtils.verifyToken(token);
            if (claims != null) {
            	String userId = (String)claims.get("userId");
            	request.setAttribute("token", JwtUtils.createToken(userId));
                chain.doFilter(request, response);
                return;
            }else{
                httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "未授权或者授权已经过期");
                return;
            }
        
        }
    }
    @Override
    public void destroy() {

    }
}