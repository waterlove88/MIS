package com.waterlove88.mis.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.waterlove88.mis.common.model.ResultMaster;
import com.waterlove88.mis.entity.member.Member;
import com.waterlove88.mis.repository.MemberRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MemberService {

	private MemberRepository memberRepository;
	
	public ResultMaster join(Member member) {
		try {
			memberRepository.save(member);
		} catch (Exception e) {
			return new ResultMaster("1002", "failure");
		}
		
		return new ResultMaster("2000", "success");
	}
	
	public ResultMaster get(Integer memNo) {
		try {
			ResultMaster resultMaster;
			Optional<Member> member = memberRepository.findById(memNo);
			
			if(member.isPresent()) {
				resultMaster = new ResultMaster("2000", "success");
				resultMaster.setBody(member.get());			
				return resultMaster;
			}
		} catch (Exception e) {
			return new ResultMaster("1002", "failure");
		}
		
		return new ResultMaster("1002", "failure");
	}
}
