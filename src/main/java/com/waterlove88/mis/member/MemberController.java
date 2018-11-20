package com.waterlove88.mis.member;

import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waterlove88.mis.common.model.ResultMaster;
import com.waterlove88.mis.member.entity.Member;
import com.waterlove88.mis.member.request.JoinRequest;

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
	
	@Autowired
	MemberRepository memberRepository;
	
	/*
	 * get member
	 */
	@GetMapping("/{memNo}")
	public ResultMaster getMember(@PathVariable Integer memNo) {
		logger.info("get member : "+memNo);
		
//		StandardPBEStringEncryptor jasypt = new StandardPBEStringEncryptor();
//        jasypt.setPassword("m2sj");      //암호화 키(password)
//        jasypt.setAlgorithm("PBEWithMD5AndDES");
// 
//        String encryptedText = jasypt.encrypt("tiger");    //암호화
//        String plainText = jasypt.decrypt(encryptedText);  //복호화
// 
//        System.out.println("encryptedText:  " + encryptedText); //암호화된 값
//        System.out.println("plainText:  " + plainText);
		
		ResultMaster resultMaster;
		Optional<Member> member = memberRepository.findById(memNo);
		
		if(member.isPresent()) {
			resultMaster = new ResultMaster("200", "success");
			resultMaster.setBody(member.get());			
			return resultMaster;
		}
		
		return new ResultMaster("1002", "failure");
	}
	
	/*
	 * join member
	 */
	@PostMapping("")
	public ResultMaster join(@Valid JoinRequest joinRequest, BindingResult bindingResult) {		
		logger.info("join member : "+joinRequest.toString());
		
		if(bindingResult.hasErrors()) {
			return new ResultMaster("1001", "Bad request");
		}
		
		try {
			memberRepository.save(joinRequest.setMemberEntity());
		} catch (Exception e) {
			logger.error("join member error : "+e.getCause().toString(), e);
			return new ResultMaster("1002", "failure");
		}
		
		return new ResultMaster("200", "success");
		
	}
}
