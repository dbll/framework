
package com.dbll.framework.common.command;

public enum CommandCode {
	
	SAY_HELLO(0x0001,SayHelloCommand.class,"测试");
	
	private int opCode;
	private Class<? extends AbstractCommand> directClass;
	private String desc;
	
	private CommandCode(int opCode, Class<? extends AbstractCommand> directClass, String desc) {
		this.opCode = opCode;
		this.directClass = directClass;
		this.desc = desc;
	}

	public int getOpCode() {
		return opCode;
	}

	public Class<? extends AbstractCommand> getDirectClass() {
		return directClass;
	}

	public String getDesc() {
		return desc;
	}
	
	
	
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

	
}