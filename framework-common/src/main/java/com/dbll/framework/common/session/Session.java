package com.dbll.framework.common.session;

import com.dbll.framework.common.protocol.AbstractPacket;

import io.netty.channel.Channel;

public interface Session {

	enum Status {
		NOT_CONNECTED, CONNECTING, CONNECTED, CLOSED
	}

	long getCreateTime();
	
	Status getStatus();
	
	void setStatus(Status status);
	
	void close();
	
	int getAccountId();

	void setAccoutId(int accountId);
	
	Channel getChannel();
	
	void destory();
	
	Session getInstance();
	
	void sendMessage(AbstractPacket packet) throws Exception;
	
}
