package com.waterlove88.mis.member.request;

import com.waterlove88.mis.member.entity.Member;

import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
public class JoinRequest {
	private String id; // 아이디
	private String statusCode; // 회원상태 (1:정상, 2:이메일미인증, 3:비밀번호 오류초과, 4:휴면, 5:기타정지)  
	private String name; // 이름
	private String gender; // 성별
	private String birth; // 생년월일
	private String nickName; // 닉네임
	private String joinPath; // 가입경로
	private String password; // 비밀번호
	
	public Member setMemberEntity() {
		return Member.builder()
				.id(id)
				.statusCode(statusCode)
				.name(name)
				.gender(gender)
				.birth(birth)
				.nickName(nickName)
				.joinPath(joinPath)
				.build();
	}

	@Override
	public String toString() {
		return "JoinRequest [id=" + id + ", statusCode=" + statusCode + ", name=" + name + ", gender=" + gender
				+ ", birth=" + birth + ", nickName=" + nickName + ", joinPath=" + joinPath + ", password=" + password
				+ "]";
	}
}
