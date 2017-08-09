package com.waterlove88.mis.member.model;

import java.sql.Date;

public class MemberHistoryInfo {
	private Integer memHisNo; // 회원이력번호
	private Integer memNo; // 회원번호
	private String memHisCode; // 수정코드 (1:이메일인증, 2:비밀번호 오류초과, 3:비밀번호 초기화, 4:휴면전환, 5:휴면해제, 6:기타정지, 7:기타정지해제)
	private String modifyIp; // 수정ip
	private Date modifyDate; // 수정날짜
	
	public void setMemHisNo(Integer memHisNo) {
		this.memHisNo = memHisNo;
	}
	public void setMemNo(Integer memNo) {
		this.memNo = memNo;
	}
	public void setMemHisCode(String memHisCode) {
		this.memHisCode = memHisCode;
	}
	public void setModifyIp(String modifyIp) {
		this.modifyIp = modifyIp;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	@Override
	public String toString() {
		return "MemberHistoryInfo [memHisNo=" + memHisNo + ", memNo=" + memNo
				+ ", memHisCode=" + memHisCode + ", modifyIp=" + modifyIp
				+ ", modifyDate=" + modifyDate + "]";
	}
}