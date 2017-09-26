package com.im.utils;

import java.security.Key;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.commons.lang3.StringUtils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class CoderUtils {

	/**
	 * 支持以下任意一种算法
	 * 
	 * <pre>
	 * PBEWithMD5AndDES 
	 * PBEWithMD5AndTripleDES 
	 * PBEWithSHA1AndDESede
	 * PBEWithSHA1AndRC2_40
	 * </pre>
	 */
	public static final String ALGORITHM = "PBEWITHMD5andDES";
	
	private static final byte[] B = new byte[]{1,2,3,4,5,6,7,8};
	private static final String P ="00000000000000";
	
	
	/**
	 * base64加密
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encryptBASE64(byte[] key) throws Exception {
		return (new BASE64Encoder()).encodeBuffer(key);
	}
	
	/**
	 * base64解密
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptBASE64(String key) throws Exception {
		return (new BASE64Decoder()).decodeBuffer(key);
	}
	
	/**
	 * 盐初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public static byte[] initSalt() throws Exception {
		byte[] salt = new byte[8];
		Random random = new Random();
		random.nextBytes(salt);
		return salt;
	}
 
	/**
	 * 转换密钥<br>
	 * 
	 * @param password
	 * @return
	 * @throws Exception
	 */
	private static Key toKey(String password) throws Exception {
		PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
		SecretKey secretKey = keyFactory.generateSecret(keySpec);
 
		return secretKey;
	}
 
	/**
	 * 加密
	 * 
	 * @param data 数据
	 * @param password 密码
	 * @param salt  盐
	 * @return
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] data, String password, byte[] salt)
			throws Exception {
 
		Key key = toKey(password);
 
		PBEParameterSpec paramSpec = new PBEParameterSpec(salt, 100);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
 
		return cipher.doFinal(data);
 
	}
 
	/**
	 * 解密
	 * 
	 * @param data  数据
	 * @param password 密码
	 * @param salt  盐
	 * @return
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] data, String password, byte[] salt)
			throws Exception {
 
		Key key = toKey(password);
 
		PBEParameterSpec paramSpec = new PBEParameterSpec(salt, 100);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
 
		return cipher.doFinal(data);
 
	}
	
	/**
	 * 简单加密
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String data) throws Exception{
		if(StringUtils.isNotBlank(data)){
			byte[] bytes = data.getBytes();
			byte[] encrypt = encrypt(bytes, P, B);
			return CoderUtils.encryptBASE64(encrypt);
		}
		return data;
	}
	
	/**
	 * 简单解密
	 * @param data
	 * @return
	 * @throws Exception 
	 *//*
	public static String decrypt(String data) throws Exception{
		if(StringUtils.isNoneBlank(data)){
			byte[] bytes = CoderUtils.decryptBASE64(data);
			byte[] decrypt = decrypt(bytes,P,B);
			return new String(decrypt);
		}
		return data;
	}*/
}
