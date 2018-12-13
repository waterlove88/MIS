package com.waterlove88.mis.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waterlove88.mis.common.model.ResultMaster;
import com.waterlove88.mis.entity.member.Member;
import com.waterlove88.mis.repository.MemberRepository;
import com.waterlove88.mis.request.login.LoginRequest;

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
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	//@Autowired
	//LoginRepository loginRepository;
	
	@Autowired
	MemberRepository memberRepository;
	
	/*
	 * login
	 * 동시 로그인 제한
	 */
	@PostMapping("")
	public ResultMaster login(@Valid LoginRequest login, BindingResult bindingResult) {		
		if(bindingResult.hasErrors()) {
			return new ResultMaster("2001", "Bad request");
		}
		
		ResultMaster resultMaster;
		Member member = memberRepository.findByid(login.getId());
		
		logger.info("getMember : "+member.getMemNo());
		
		if(member != null) {
			//Optional<LoginRequest> password = loginRepository.findById(login.getId());
			
			resultMaster = new ResultMaster("2000", "success");
			resultMaster.setBody(member.getMemNo());
			return resultMaster;
		}
		
		return new ResultMaster("2000", "success");
	}
	
	/*
	 * logout
	 */
		
	/*
	 * get login histroy
	 */
}
