package com.dbll.framework.common.protocol;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dbll.framework.common.protocol.packet.TestPacket;

public enum Protocol {
	
	TEST_PROTOCOL(0xFFF, TestPacket.class, "测试");
	
	
	private int opCode;
	private Class<? extends AbstractPacket> directClass;
	private String desc;
	
	private Protocol(int opCode, Class<? extends AbstractPacket> directClass, String desc) {
		this.opCode = opCode;
		this.directClass = directClass;
		this.desc = desc;
	}

	private static final Logger LOG = LoggerFactory.getLogger(Protocol.class);
	
	private static final HashMap<Integer, Class<? extends AbstractPacket>> DIRECT_MAP = new HashMap<>(Protocol.values().length);
	
	public static final void initializeDirectMap(){
		
		Protocol[] values = Protocol.values();
		for (Protocol protocol : values) {
			DIRECT_MAP.put(protocol.opCode, protocol.directClass);
			LOG.debug("PACKET {} REGISTER FOR CLASS {}", protocol.opCode, protocol.getDeclaringClass().getName());
		}
	}
	
	public Class<? extends AbstractPacket> getDirection(int opCode){
		return DIRECT_MAP.get(opCode);
	}

	public int getOpCode() {
		return opCode;
	}

	public Class<? extends AbstractPacket> getDirectClass() {
		return directClass;
	}

	public String getDesc() {
		return desc;
	}
	
}
