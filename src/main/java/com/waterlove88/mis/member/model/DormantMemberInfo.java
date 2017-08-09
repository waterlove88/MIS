package com.waterlove88.mis.member.model;

import java.sql.Date;

public class DormantMemberInfo extends MemberInfo {
	private Date dormantDate; // 휴면날짜

	public void setDormantDate(Date dormantDate) {
		this.dormantDate = dormantDate;
	}

	@Override
	public String toString() {
		return "DormantMemberInfo [dormantDate=" + dormantDate + ", memNo="
				+ memNo + ", id=" + id + ", statusCode=" + statusCode
				+ ", name=" + name + ", gender=" + gender + ", birth=" + birth
				+ ", nickName=" + nickName + ", createDate=" + createDate
				+ ", modifyDate=" + modifyDate + "]";
	}
}
