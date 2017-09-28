package com.turing.framework.log;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import com.turing.system.entity.SysUser;

@Aspect
public class Log {
	@Pointcut("execution(* com.turing.*.controller.*.*(..))")
	public void any() {

	}

	@Autowired
	HttpServletRequest request;

	Logger log = Logger.getLogger(Log.class);

	@Around("any()")
	public Object doLog(ProceedingJoinPoint p) throws Throwable {
		String ip = request.getRemoteAddr();
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		String name = "";
		if (user != null) {
			name = user.getUserName();
		}
		String time = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss")
				.format(new Date());
		String className = p.getTarget().getClass().getSimpleName();
		String method = p.getSignature().getName();
		log.info(ip + "[" + name + "] [" + time + "]" + className + "."
				+ method);
		return p.proceed();
	}
}
