package com.dbll.framework.common.protocol.security;

public interface Algorithm {

	/**
	 * 加密
	 * @param data
	 */
	void encryption(byte[] data);
	
	/**
	 * 解密
	 */
	void decryption(byte[] data);
	
}
