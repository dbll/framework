
package com.dbll.framework.common.command;

public enum CommandCode {
	
	SAY_HELLO
	
//	TEST_PROTOCOL(0xFFF, TestPacket.class, "测试");
//	
//	
//	private int opCode;
//	private Class<? extends AbstractPacket> directClass;
//	private String desc;
//	
//	private ProtocolCode(int opCode, Class<? extends AbstractPacket> directClass, String desc) {
//		this.opCode = opCode;
//		this.directClass = directClass;
//		this.desc = desc;
//	}
//
//	private static final Logger LOG = LoggerFactory.getLogger(ProtocolCode.class);
//	
//	private static final HashMap<Integer, Class<? extends AbstractPacket>> DIRECT_MAP = new HashMap<>(ProtocolCode.values().length);
//	
//	public static final void initializeDirectMap(){
//		
//		ProtocolCode[] values = ProtocolCode.values();
//		for (ProtocolCode protocol : values) {
//			DIRECT_MAP.put(protocol.opCode, protocol.directClass);
//			LOG.debug("PACKET {} REGISTER FOR CLASS {}", protocol.opCode, protocol.getDeclaringClass().getName());
//		}
//	}
//	
//	public Class<? extends AbstractPacket> getDirection(int opCode){
//		return DIRECT_MAP.get(opCode);
//	}
//
//	public int getOpCode() {
//		return opCode;
//	}
//
//	public Class<? extends AbstractPacket> getDirectClass() {
//		return directClass;
//	}
//
//	public String getDesc() {
//		return desc;
//	}
	
}