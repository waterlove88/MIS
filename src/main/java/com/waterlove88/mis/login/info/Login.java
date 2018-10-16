package com.waterlove88.mis.login.info;

import javax.validation.constraints.Pattern;

/**
 * 로그인 정보 클래스
 *  
 * @author waterlove88 
 * 2017. 11. 10
 */
public class Login {
	
	// 5~20자 사이 영문소문자 또는 영문소문자+숫자(첫글자는 반드시 영문소문자)
	@Pattern(regexp="^[a-z]+[a-z0-9]{4,19}$")
	private String id;
	
	// 10자 이상 영문자를 포함한 숫자or특수문자(!@#$%^&*+-=)or둘다 사용가능
	@Pattern(regexp="^(?=.*[a-zA-Z])(?=.*[0-9!@#$%^&*+-=]).{10,}$")
	private String password;
	
	public void setId(String id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "LoginInfo [id=" + id + ", password=" + password + "]";
	}
}
