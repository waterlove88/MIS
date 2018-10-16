package com.waterlove88.mis.member.entity;

import java.sql.Date;

/**
 * 휴면회원 클래스
 * 회원 클래스를 상속
 * 
 * @author waterlove88 
 * 2017. 11. 10
 */
public class DormantMember extends Member {

	public DormantMember(Integer memNo, String id, String statusCode, String name, String gender, String birth,
			String nickName, String joinPath) {
		super(memNo, id, statusCode, name, gender, birth, nickName, joinPath);
		// TODO Auto-generated constructor stub
	}

	private Date dormantDate; // 휴면날짜

	public void setDormantDate(Date dormantDate) {
		this.dormantDate = dormantDate;
	}
}
