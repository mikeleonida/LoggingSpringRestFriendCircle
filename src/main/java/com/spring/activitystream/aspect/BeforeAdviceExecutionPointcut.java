package com.spring.activitystream.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.spring.activitystream.log.LogFile;

@Aspect
@Component
public class BeforeAdviceExecutionPointcut {
	@Before("execution(* com.spring.activitystream.controller.UserController.*())")
	public void beforeUserControllerNoArgs(JoinPoint jp) {
		LogFile.log("\nINFO: UserController method no args called");
	}
	
	@Before("execution(* com.spring.activitystream.controller.UserController.*(*))")
	public void beforeUserControllerOneArg(JoinPoint jp) {
		LogFile.log("\nINFO: UserController method one arg called");
	}
	
	@Before("execution(* com.spring.activitystream.controller.UserController.*(*, *))")
	public void beforeUserControllerTwoArgs(JoinPoint jp) {
		LogFile.log("\nINFO: UserController updateUser method called");
	}
}
