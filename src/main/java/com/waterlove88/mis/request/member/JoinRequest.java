package com.waterlove88.mis.request.member;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import com.waterlove88.mis.common.utils.EncryptionUtils;
import com.waterlove88.mis.entity.member.Member;

import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
public class JoinRequest {
	
	// 5~20자 사이 영문소문자 또는 영문소문자+숫자(첫글자는 반드시 영문소문자)
	@Email(message = "아이디를 확인해주세요.")
	private String id; // 아이디
	
	// 처음 회원 가입할때 무조껀 이메일미인증
	private Integer statusCode = 2; // 회원상태 (1:정상, 2:이메일미인증, 3:비밀번호 오류초과, 4:휴면, 5:기타정지) 
	private String gender; // 성별
	
	@Pattern(regexp="^[0-9]*$")
	private String birth; // 생년월일
	private String nickName; // 닉네임
	private String joinPath; // 가입경로
	
	@Pattern(regexp="^(?=.*[a-zA-Z])(?=.*[0-9!@#$%^&*+-=]).{10,}$")
	private String password; // 비밀번호
	
	public Member setMemberEntity() {
		return Member.builder()
				.id(id)
				.statusCode(statusCode)
				.gender(gender)
				.birth(birth)
				.nickName(nickName)
				.joinPath(joinPath)
				.password(new EncryptionUtils().encode(password))
				.build();
	}
	
	@Override
	public String toString() {
		return "JoinRequest [id=" + id + ", statusCode=" + statusCode + ", gender=" + gender + ", birth=" + birth
				+ ", nickName=" + nickName + ", joinPath=" + joinPath + ", password=" + password + "]";
	}
}
