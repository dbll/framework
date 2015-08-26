package com.dbll.framework.common.server;

public interface Server {

	public interface TransmissionProtocol {

	}

	public enum TRANSMISSION_PROTOCOL implements TransmissionProtocol {
		TCP, UDP;
	}

	TransmissionProtocol getTransmissionProtocol();
	
	/**
	 * stop the server
	 */
	public void shutdown() throws Exception;

	/**
	 * stop the server
	 */
	public void startup() throws Exception;
	
	public int getBindPort();
	
}
