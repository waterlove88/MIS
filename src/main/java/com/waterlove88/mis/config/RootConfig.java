package com.waterlove88.mis.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 환경설정 클래스
 * 
 * @author waterlove88 
 * 2017. 11. 10
 */
@Configuration
@ComponentScan(basePackages = { "com.waterlove.mis" })
@PropertySource("classpath:properties/${spring.profiles.active}/application.properties")
public class RootConfig {
	
	// 환경설정 등록
	// interceptor, aop, 기타 context에 연동되는 설정
}
