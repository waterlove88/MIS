package com.waterlove88.mis.common.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;

/**
 * 암호화 클래스
 * 간단하게 MD5 와 SHA-256을 사용했으나(salt로 MD5, 전체 해싱으로 SHA-256) 두개 모두 변경 예정
 * 
 * @author waterlove88 
 * 2017. 11. 10
 */
public class EncryptionUtils {

	private HashMap<String, String> encryptData = new HashMap<String, String>();

	/*
	 * password hashing method
	 */
	public HashMap<String, String> hashingToPassword(String str) throws NoSuchAlgorithmException {
		// create salt key
		String saltKey = createSalt();
        
        // encrypt pw
        String encryptionStr = getSHA256Digest(saltKey+str);
		
		encryptData.put("saltKey", saltKey);
		encryptData.put("encryptionStr", encryptionStr);
		
		return encryptData;
	}

	/*
	 * create salt key : md5
	 */
	private String createSalt() throws NoSuchAlgorithmException {
		// random key create
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		String randomNum = new Integer(random.nextInt()).toString();
        
		// md5 hashing
		MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] md5Digest =  md5.digest(randomNum.getBytes());
		BigInteger number = new BigInteger(1, md5Digest);
        
		return number.toString(16);
	}
	
	/*
	 * sha-256 hashing
	 */
	public String getSHA256Digest(String input) throws NoSuchAlgorithmException{
		StringBuffer encryptData = new StringBuffer();
		
		MessageDigest sha = MessageDigest.getInstance("SHA-256");
		sha.update(input.getBytes());
		
		byte[] messageDigest = sha.digest();
		for(int i=0; i<messageDigest.length; i++){
			encryptData.append(Integer.toHexString(messageDigest[i] & 0xFF));
		}
		
		return encryptData.toString();
	}
}
