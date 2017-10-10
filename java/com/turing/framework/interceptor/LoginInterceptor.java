package com.turing.framework.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.turing.system.entity.SysUser;

public class LoginInterceptor implements HandlerInterceptor{

	
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 登录拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());
		
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		if(user==null){
			request.setAttribute("msg", "relogin");
			request.getRequestDispatcher("/error/error.jsp").forward(request, response);
			return false;
		}else{
			return true;
		}
		
		
	}
}
