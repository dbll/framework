package com.dbll.framework.common.protocol.security;

public class SecurityContext {
	
	/**
	 * 算法
	 */
	private Algorithm algorithm;
	
	public SecurityContext() {
	}
	
	public SecurityContext(Algorithm algorithm) {
		this.algorithm = algorithm;
	}
	
	public void encryption(byte[] data){
		algorithm.encryption(data);
	}
	
	public void decryption(byte[] data){
		algorithm.decryption(data);
	}
}
