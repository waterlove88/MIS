package com.waterlove88.mis.common.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;

public class EncryptionUtils {

	private HashMap<String, String> encryptData = new HashMap<String, String>();

	public HashMap<String, String> encryption(String str) throws NoSuchAlgorithmException {
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		String randomNum = new Integer(random.nextInt()).toString();
        
		// salt key create
		MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] md5Digest =  md5.digest(randomNum.getBytes());
		BigInteger number = new BigInteger(1, md5Digest);
		
        String saltKey = number.toString(16);
        
        // encrypt pw
        String encryptionStr = getSHA256Digest(saltKey+str);
		
		encryptData.put("saltKey", saltKey);
		encryptData.put("encryptionStr", encryptionStr);
		
		return encryptData;
	}
	
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
