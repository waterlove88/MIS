package com.waterlove88.mis.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.waterlove88.mis.common.model.ResultMaster;
import com.waterlove88.mis.common.utils.EncryptionUtils;
import com.waterlove88.mis.entity.member.Member;
import com.waterlove88.mis.repository.MemberRepository;
import com.waterlove88.mis.request.login.LoginRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoginService {

	private MemberRepository memberRepository;
	private EncryptionUtils encryptionUtils;
	
	public ResultMaster login(LoginRequest loginRequest) {
		try {
			
			Member member = memberRepository.findByid(loginRequest.getId());
			
			if(!StringUtils.isEmpty(member) && encryptionUtils.matches(loginRequest.getPassword(), member.getPassword())) {
				return new ResultMaster("1000", "success");	
			}
			return new ResultMaster("1002", "failure");
		} catch (Exception e) {
			return new ResultMaster("1002", "failure");
		}
	}
}
