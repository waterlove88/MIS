package com.waterlove88.mis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * 맨 처음 시작 클래스
 * SpringBootApplication 으로 지정
 * 
 * @author waterlove88 
 * 2017. 11. 10
 */
@SpringBootApplication
@EnableJpaAuditing
public class MisApplication {

	public static void main(String[] args) {
		SpringApplication.run(MisApplication.class, args);
	}
}