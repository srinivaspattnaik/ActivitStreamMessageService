package com.stackroute.activitystream.messageutility;

import java.util.List;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerUtility 
{
	 private static final Logger LOGGER = LoggerFactory.getLogger(LoggerUtility.class);

	 @Before("execution(public * com.stackroute.activitystream.userutility.UserController.get*(..))")
	 public void beforeEveryMethod() 
	 {
		 //Better to extract method parameters and log it ( except password)
	        LOGGER.info("--- Method Executed at ---");
	 }
}
