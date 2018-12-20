package com.waterlove88.mis.controller;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waterlove88.mis.common.model.ResultMaster;
import com.waterlove88.mis.request.member.JoinRequest;
import com.waterlove88.mis.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 회원 controller
 * RestController로 데이터를 반환
 * 
 * @author waterlove88 
 * 2017. 11. 10
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/member")
public class MemberController {
	
	private MemberService memberService;
	
	/*
	 * get member
	 */
	@GetMapping("/{memNo}")
	public ResultMaster get(@PathVariable Integer memberSeq) {
		log.info("get member : "+memberSeq);
		
		try {
			return memberService.get(memberSeq);
		} catch (Exception e) {
			log.error("join member error : "+e.getCause().toString(), e);
			return new ResultMaster("1002", "failure");
		}
	}
	
	/*
	 * join member
	 */
	@PostMapping("")
	public ResultMaster join(@Valid JoinRequest joinRequest, BindingResult bindingResult) {		
		log.info("join member : "+joinRequest.toString());
		
		if(bindingResult.hasErrors()) {
			return new ResultMaster("1001", "Bad request");
		}
		
		try {
			return memberService.join(joinRequest.setMemberEntity());
		} catch (Exception e) {
			log.error("join member error : "+e.getCause().toString(), e);
			return new ResultMaster("1002", "failure");
		}
	}
}
