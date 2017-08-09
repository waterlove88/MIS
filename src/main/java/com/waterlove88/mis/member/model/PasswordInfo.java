package com.waterlove88.mis.member.model;

public class PasswordInfo {
	private Integer memNo; // 회원번호
	private String password; // 비밀번호
	private String saltKey; // 소금값
	private String createDate; // 생성날짜
	
	public void setMemNo(Integer memNo) {
		this.memNo = memNo;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setSaltKey(String saltKey) {
		this.saltKey = saltKey;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	@Override
	public String toString() {
		return "PasswordInfo [memNo=" + memNo + ", password=" + password
				+ ", saltKey=" + saltKey + ", createDate=" + createDate + "]";
	}
}
