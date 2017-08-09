package com.waterlove88.mis.member.model;

import java.sql.Date;

public class MemberInfo {
	protected Integer memNo; // 회원번호
	protected String id; // 아이디
	protected String statusCode; // 회원상태 (1:정상, 2:이메일미인증, 3:비밀번호 오류초과, 4:휴면, 5:기타정지)  
	protected String name; // 이름
	protected String gender; // 성별
	protected String birth; // 생년월일
	protected String nickName; // 닉네임
	protected Date createDate; // 가입날짜
	protected Date modifyDate; // 수정날짜
	
	public void setMemNo(Integer memNo) {
		this.memNo = memNo;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	@Override
	public String toString() {
		return "MemberInfo [memNo=" + memNo + ", id=" + id + ", statusCode="
				+ statusCode + ", name=" + name + ", gender=" + gender + ", birth="
				+ birth + ", nickName=" + nickName + ", createDate="
				+ createDate + ", modifyDate=" + modifyDate + "]";
	}
}
