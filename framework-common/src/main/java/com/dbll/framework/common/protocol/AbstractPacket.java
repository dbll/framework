package com.dbll.framework.common.protocol;

public abstract class AbstractPacket implements Packet {
	
	private final int opCode;
	
 	
	public AbstractPacket(int opCode) {
		this.opCode = opCode;
	}
	
	public int getOpCode(){
		return opCode;
	}

	
	
}
