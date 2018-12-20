package com.waterlove88.mis.controller;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waterlove88.mis.common.model.ResultMaster;
import com.waterlove88.mis.request.login.LoginRequest;
import com.waterlove88.mis.service.LoginService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 로그인 controller
 * RestController로 데이터를 반환
 * 
 * @author waterlove88 
 * 2017. 11. 10
 */
@Slf4j
@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {
	private LoginService loginService;
	
	/*
	 * login
	 * 동시 로그인 제한
	 */
	@PostMapping("")
	public ResultMaster login(@Valid LoginRequest loginRequest, BindingResult bindingResult) {	
		log.info("loginRequest : "+loginRequest.toString());
		
		if(bindingResult.hasErrors()) {
			return new ResultMaster("1001", "Bad request");
		}
		
		return loginService.login(loginRequest);
	}
	
	/*
	 * logout
	 */
		
	/*
	 * get login histroy
	 */
}
