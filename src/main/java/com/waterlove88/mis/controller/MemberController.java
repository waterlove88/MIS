package com.waterlove88.mis.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waterlove88.mis.common.model.ResultMaster;
import com.waterlove88.mis.request.member.JoinRequest;
import com.waterlove88.mis.service.MemberService;

/**
 * 회원 controller
 * RestController로 데이터를 반환
 * 
 * @author waterlove88 
 * 2017. 11. 10
 */
@RestController
@RequestMapping("/member")
public class MemberController {
	
	Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	private MemberService memberService;
	
	public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
	
	/*
	 * get member
	 */
	@GetMapping("/{memNo}")
	public ResultMaster get(@PathVariable Integer memNo) {
		logger.info("get member : "+memNo);
		
		try {
			return memberService.get(memNo);
		} catch (Exception e) {
			logger.error("join member error : "+e.getCause().toString(), e);
			return new ResultMaster("1002", "failure");
		}
	}
	
	/*
	 * join member
	 */
	@PostMapping("")
	public ResultMaster join(@Valid JoinRequest joinRequest, BindingResult bindingResult) {		
		logger.info("join member : "+joinRequest.toString());
		
		if(bindingResult.hasErrors()) {
			return new ResultMaster("2001", "Bad request");
		}
		
		try {
			logger.info("aaa : "+joinRequest.setMemberEntity().toString());
			
			return memberService.join(joinRequest.setMemberEntity());
		} catch (Exception e) {
			logger.error("join member error : "+e.getCause().toString(), e);
			return new ResultMaster("1002", "failure");
		}
	}
}
