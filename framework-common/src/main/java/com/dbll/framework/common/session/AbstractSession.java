package com.dbll.framework.common.session;

import io.netty.channel.Channel;
import io.netty.channel.ChannelId;

public abstract class AbstractSession implements Session{
	
	private Status status = Status.NOT_CONNECTED;

	private long createTime;
	
	private int accountId;
	
	private ChannelId channelId;
	
	private Session session;
	
	protected AbstractSession(Channel channel) {
		this.channelId = channel.id();
		createTime = System.currentTimeMillis();
	}
	
	public abstract void sendMessage(byte[] bytes) throws Exception;

	public abstract void close();
	
	@Override
	public Session getInstance(){
		return session;
	}
	
	@Override
	public void destory() {
		this.status = Status.CLOSED;
	}
	
	@Override
	public long getCreateTime() {
		return createTime;
	}

	@Override
	public Status getStatus() {
		return status;
	}

	@Override
	public int getAccountId() {
		return accountId;
	}

	@Override
	public void setAccoutId(int accountId) {
		this.accountId = accountId;
	}

	@Override
	public ChannelId getChannelId() {
		return channelId;
	}

	@Override
	public void setStatus(Status status) {
		this.status = status;
	}

}
