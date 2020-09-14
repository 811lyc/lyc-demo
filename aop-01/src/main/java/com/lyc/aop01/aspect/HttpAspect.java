package com.lyc.aop01.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author LYC
 * @desc  定义切点  @Component注册到spring
 * @create 2020-09-11 14:12
 **/
@Component
@Aspect
public class HttpAspect {

	private final Logger logger = LoggerFactory.getLogger(HttpAspect.class);
	/**
	 * 定义切点   girlcontroller下的方法
	 */
	@Pointcut("execution(public * com.lyc.aop01.controller.GirlController.*())")
	public void log(){

	}

	/**
	 * 前置通知
	 * @param joinPoint
	 */
	@Before("log()")
	public void doBefore(JoinPoint joinPoint){
		// 在SpringMVC的源代码中提供了一个封装过的ThreadLocal，其中保存了每次请求的HttpServletRequest对象，（详细请看org.springframework.web.context.request.ServletRequestAttributes的源代码）
		ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		if(Objects.isNull(attributes)){
			return;
		}

		HttpServletRequest request = attributes.getRequest();

		//地址
		logger.info("测试试试 url={}",request.getRequestURI());
		//方法
		logger.info("测试试试 method={}",request.getMethod());
		//ip
		logger.info("测试试试 ip={}",request.getRemoteAddr());
		//参数
		logger.info("测试试试 args={}",joinPoint.getArgs());
		//类方法
		logger.info("class_method",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());



	}

	/**
	 * 后置通知
	 */
	@After("log()")
	public void doAfter(){
		logger.info("方法执行后执行！！");
	}

	/**
	 * 正常返回
	 * @param object
	 */
	@AfterReturning(returning = "object", pointcut = "log()")
	public void doAfterReturn(Object object){
		logger.info("response = {}",object.toString());
	}

}
