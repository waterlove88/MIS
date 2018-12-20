package com.waterlove88.mis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.waterlove88.mis.entity.member.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

	Member findByid(String id);
	Member findBymemberSeq(Integer memberSeq);
	
}
