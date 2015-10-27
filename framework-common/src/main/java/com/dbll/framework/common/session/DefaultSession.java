package com.dbll.framework.common.session;

import io.netty.channel.Channel;

public class DefaultSession extends AbstractSession{
	
	private DefaultSession(Channel channel) {
		super(channel);
	}

	@Override
	public void sendMessage(byte[] packet) throws Exception {
		Channel channel = SessionGroup.ALL_CHANNELS.find(getChannelId());
		if (channel.isActive()) {
			channel.writeAndFlush(packet);
		}
		
	}

	@Override
	public void close() {
		SessionGroup.ACCOUNT_SESSION_MAP.remove(getAccountId());
	}
	
	public static Session build(Channel channel){
		return new DefaultSession(channel);
	}

}
