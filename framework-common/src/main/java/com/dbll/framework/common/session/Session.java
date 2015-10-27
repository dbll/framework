package com.dbll.framework.common.session;

import io.netty.channel.ChannelId;

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
	
	ChannelId getChannelId();
	
	void destory();
	
	Session getInstance();
	
	void sendMessage(byte[] packet) throws Exception;
	
}
