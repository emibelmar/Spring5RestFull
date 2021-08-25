package com.ebmdev.di.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutExample {

	// @Pointcut("execution(* com.ebmdev.di.aop.TargetObject.*(..))")
	// @Pointcut("within(com.ebmdev.di.aop.*)")
	@Pointcut("@annotation(EbmdevAnnotation)")
	public void targetObjectMethods() {
	}
}
