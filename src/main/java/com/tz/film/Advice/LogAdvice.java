package com.tz.film.Advice;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Repository;

/**   
*    
* 项目名称：filmSystem   
* 类名称：LogAdvice   
* 类描述：   使用aspectj操作日志记录类
* 创建人：edwarder   
* 创建时间：2017年10月18日 上午10:12:58   
*       
*/
@Repository
@Aspect
public class LogAdvice {
	/**
	 * 在进入方法前记录
	 */
	@Before(value="execution(* com.tz.film..*(..))")
	public void lonInfo(JoinPoint point){
		String className = point.getTarget().getClass().getSimpleName();
		String methodName = point.getSignature().getName();
		System.out.println(className 
				+ "类" + methodName 
				+ "方法，于" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "被访问");
	}
}
