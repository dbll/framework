package com.dbll.framework.common.protocol;

import java.util.HashMap;
import java.util.Map;

public class PacketDirect {
	
	public static final int MAX_PACKET_OPTION_CODE = 0xFFF;

	private final Map<Integer, Class<? extends Packet>> packetMap = new HashMap<>(MAX_PACKET_OPTION_CODE);
	
	protected void registHandler(Protocol protocol){
//		packetMap.put(protocol., value)
	}
}
