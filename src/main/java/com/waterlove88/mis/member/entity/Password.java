package com.waterlove88.mis.member.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.waterlove88.mis.common.model.BaseTimeEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 비밀번호 클래스
 *  
 * @author waterlove88 
 * 2017. 11. 10
 */
@Entity
@Getter
@NoArgsConstructor
public class Password extends BaseTimeEntity {
	
	@Id
	private Integer memNo; // 회원번호
	private String password; // 비밀번호
	private String saltKey; // 소금값	
	
	@Builder
	public Password(Integer memNo, String password) {
		super();
		this.memNo = memNo;
		this.password = password;
		this.saltKey = createSaltKey();
	}
	
	public String createSaltKey() {
		return null;
	}
	
	@Override
	public String toString() {
		return "PasswordInfo [memNo=" + memNo + ", password=" + password
				+ ", saltKey=" + saltKey + ", createDate=" + getCreateDate() + "]";
	}
}
