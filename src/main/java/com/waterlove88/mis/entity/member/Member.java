package com.waterlove88.mis.entity.member;

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
	private Integer memNo; // 회원번호
	
	@Column(unique = true)
	private String id; // 아이디
	private Integer statusCode; // 회원상태 (1:정상, 2:이메일미인증, 3:비밀번호 오류초과, 4:휴면, 5:기타정지)  
	private String name; // 이름
	private String gender; // 성별
	private String birth; // 생년월일
	private String nickName; // 닉네임
	private String joinPath; // 가입경로	
	private String password; // 비밀번호

	@Builder
	public Member(Integer memNo, String id, Integer statusCode, String name, String gender, String birth,
			String nickName, String joinPath, String password) {
		super();
		this.memNo = memNo;
		this.id = id;
		this.statusCode = statusCode;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
		this.nickName = nickName;
		this.joinPath = joinPath;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Member [memNo=" + memNo + ", id=" + id + ", statusCode=" + statusCode + ", name=" + name + ", gender="
				+ gender + ", birth=" + birth + ", nickName=" + nickName + ", joinPath=" + joinPath + ", password="
				+ password + "]";
	}
}
