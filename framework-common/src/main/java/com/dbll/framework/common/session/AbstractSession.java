package com.dbll.framework.common.session;

import io.netty.channel.Channel;

public abstract class AbstractSession implements Session{
	
	private Status status = Status.NOT_CONNECTED;

	private long createTime;
	
	private int accountId;
	
	private Channel channel;
	
	private Session session;
	
	protected AbstractSession(Channel channel) {
		this.channel = channel;
		createTime = System.currentTimeMillis();
	}
	
	public abstract void sendMessage(com.dbll.framework.common.protocol.AbstractPacket packet) throws Exception;

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
	public Channel getChannel() {
		return channel;
	}

	@Override
	public void setStatus(Status status) {
		this.status = status;
	}

}
