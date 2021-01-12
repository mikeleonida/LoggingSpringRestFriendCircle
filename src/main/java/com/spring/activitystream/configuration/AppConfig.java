package com.spring.activitystream.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages= {"com.spring.activitystream.aspect", 
		"com.spring.activitystream.controller", "com.spring.activitystream.log"})
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AppConfig {

}
