package com.waterlove88.mis.login.model;

import java.sql.Date;

/**
 * 로그인 히스토리 클래스
 *  
 * @author waterlove88 
 * 2017. 11. 10
 */
public class LoginHistroyInfo {
	private Integer loginHisNo; // 로그인이력번호
	private Integer memNo; // 회원번호
	private String serviceCode; // 서비스코드 (1:OnePocker)
	private String loginDevice; // 로그인 기기
	private String loginIp; // 로그인ip
	private Date loginDate; // 로그인날짜
	
	public void setLoginHisNo(Integer loginHisNo) {
		this.loginHisNo = loginHisNo;
	}
	public void setMemNo(Integer memNo) {
		this.memNo = memNo;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public void setLoginDevice(String loginDevice) {
		this.loginDevice = loginDevice;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	
	@Override
	public String toString() {
		return "LoginHistroyInfo [loginHisNo=" + loginHisNo + ", memNo="
				+ memNo + ", serviceCode=" + serviceCode + ", loginDevice="
				+ loginDevice + ", loginIp=" + loginIp + ", loginDate="
				+ loginDate + "]";
	}
}
