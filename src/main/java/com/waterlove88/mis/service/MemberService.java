package com.waterlove88.mis.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
			return new ResultMaster("1000", "success");
		} catch (Exception e) {
			return new ResultMaster("1002", "failure");
		}
	}
	
	public ResultMaster get(Integer memberSeq) {
		try {
			ResultMaster resultMaster;
			Member member = memberRepository.findBymemberSeq(memberSeq);
			
			if(!StringUtils.isEmpty(member)) {
				resultMaster = new ResultMaster("1000", "success");
				resultMaster.setBody(member);			
				return resultMaster;
			}
			
			return new ResultMaster("1002", "no selet");
		} catch (Exception e) {
			return new ResultMaster("1003", "failure");
		}
	}
}
