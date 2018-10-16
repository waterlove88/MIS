package com.waterlove88.mis.member;

import org.springframework.data.jpa.repository.JpaRepository;

import com.waterlove88.mis.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
