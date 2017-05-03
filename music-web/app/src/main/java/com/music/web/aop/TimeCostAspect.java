package com.music.web.aop;


import com.music.web.constant.CommonConstants;
import com.music.web.entity.User;
import com.music.web.service.UserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.util.StopWatch;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Aspect
@Component
@Order(-5)
public class TimeCostAspect {

	private Logger logger = LoggerFactory.getLogger(TimeCostAspect.class);

	@Autowired
	private UserService userService;


	@Pointcut("execution(public * com.music.web.controller.*.*(..))")
	public void timeCost(){}
	
	@Around("timeCost()")
	public Object count(ProceedingJoinPoint thisJoinPoint) throws Throwable{
		StopWatch watch = new StopWatch();
		watch.start();
		Object o = thisJoinPoint.proceed();
		watch.stop();
		logger.info(
				"["+thisJoinPoint.getSignature().getDeclaringTypeName()+"]" +
				"["+thisJoinPoint.getSignature().getName()+"]" +
				" cost " + watch.getTotalTimeMillis()
				);
		return o;
	}

	@Pointcut("execution(public * com.music.web.controller.*.*(" +
			"javax.servlet.http.HttpServletRequest,org.springframework.ui.Model,..))")
	public void modelUser(){}

	@org.aspectj.lang.annotation.Before("modelUser()")
	public void modelUserInfo(JoinPoint joinPoint){
		Object[] args = joinPoint.getArgs();
		HttpServletRequest request = (HttpServletRequest)args[0];
		Model model = (Model)args[1];

		if(request!=null && model!=null){
			Object obj = request.getSession().getAttribute(CommonConstants.CURRENT_USER);
			User user = obj == null ? null : (User)obj;
			if(user==null){
				Cookie[] cookies = request.getCookies();//这样便可以获取一个cookie数组
				if (null!=cookies) {
					for(Cookie cookie : cookies){
						if(cookie.getName().equals(CommonConstants.CURRENT_USER)){
							String id = cookie.getValue();
							if(id != null){
								user = userService.getUserById(id);
								if(null != user && user.getStatus()>0){
									user.setPassword(null);
									HttpSession session = request.getSession(true);
									String sessionId = session.getId();
									request.getSession().setAttribute(CommonConstants.CURRENT_USER,user);
								}
							}
						}
					}
				}
			}

			model.addAttribute("user",user);
		}
	}
}
