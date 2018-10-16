package com.waterlove88.mis.login;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waterlove88.mis.common.model.ResultMaster;
import com.waterlove88.mis.login.info.Login;

/**
 * 로그인 controller
 * RestController로 데이터를 반환
 * 
 * @author waterlove88 
 * 2017. 11. 10
 */
@RestController
@RequestMapping("/login")
public class LoginController {
	
	/*
	 * login
	 * 동시 로그인 제한
	 */
	@PostMapping("")
	public ResultMaster login(@Valid Login loginInfo, BindingResult bindingResult) {		
		if(bindingResult.hasErrors()) {
			return new ResultMaster("1001", "Bad request");
		}
		
		return new ResultMaster("200", "success");
	}
	
	/*
	 * logout
	 */
		
	/*
	 * get login histroy
	 */
}
