package com.dbll.framework.common.protocol;

import com.google.protobuf.AbstractMessage;

public interface Packet {

	public AbstractMessage Unpacked(byte[] data);
	
	public byte[] packed(AbstractMessage message);
	
	public void sendMessage(byte[] message);
}
