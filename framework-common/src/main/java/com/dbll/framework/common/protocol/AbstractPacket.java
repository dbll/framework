package com.dbll.framework.common.protocol;

import lombok.Getter;

public abstract class AbstractPacket implements Packet {
	
	@Getter
	protected int opCode;

	

}
