package com.dbll.framework.common.protocol.packet;

import com.dbll.framework.common.protocol.AbstractPacket;
import com.dbll.framework.common.protocol.Protocol;
import com.google.protobuf.AbstractMessage;

public class TestPacket extends AbstractPacket{

	@Override
	public AbstractMessage Unpacked(byte[] data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] packed(AbstractMessage message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOpCode() {
		opCode = Protocol.TEST_PROTOCOL.getOpCode();
	}


}
