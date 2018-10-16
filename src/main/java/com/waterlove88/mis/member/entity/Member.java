package com.waterlove88.mis.member.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.waterlove88.mis.common.model.BaseTimeEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 회원정보 클래스
 *  
 * @author waterlove88 
 * 2017. 11. 10
 */
@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseTimeEntity {
	
	@Id @GeneratedValue
	protected Integer memNo; // 회원번호
	
	@Column(unique = true)
	protected String id; // 아이디
	protected String statusCode; // 회원상태 (1:정상, 2:이메일미인증, 3:비밀번호 오류초과, 4:휴면, 5:기타정지)  
	protected String name; // 이름
	protected String gender; // 성별
	protected String birth; // 생년월일
	protected String nickName; // 닉네임
	protected String joinPath; // 가입경로	

	@Builder
	public Member(Integer memNo, String id, String statusCode, String name, String gender, String birth,
			String nickName, String joinPath) {
		super();
		this.memNo = memNo;
		this.id = id;
		this.statusCode = statusCode;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
		this.nickName = nickName;
		this.joinPath = joinPath;
	}
	
	@Override
	public String toString() {
		return "Member [memNo=" + memNo + ", id=" + id + ", statusCode=" + statusCode + ", name=" + name + ", gender="
				+ gender + ", birth=" + birth + ", nickName=" + nickName + ", joinPath=" + joinPath + ", createDate="
				+ getCreateDate() + ", modifyDate=" + getModifyDate() + "]";
	}
}
