package com.dbll.framework.common.protocol;

import com.google.protobuf.AbstractMessage;

public interface Packet {
	
	void setOpCode();
	
	int getOpCode();

	AbstractMessage Unpacked(byte[] data);
	
	byte[] packed(AbstractMessage message);
	
}