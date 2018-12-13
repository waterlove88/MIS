package com.waterlove88.mis.common.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 암호화 클래스
 * 
 * 
 * @author waterlove88 
 * 2017. 11. 10
 */

public class EncryptionUtils implements PasswordEncoder {
	private PasswordEncoder passwordEncoder;
	
	public EncryptionUtils() {
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
	@Override
	public String encode(CharSequence rawPassword) {
		return passwordEncoder.encode(rawPassword);
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return passwordEncoder.matches(rawPassword, encodedPassword);
	}
}
