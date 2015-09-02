package com.dbll.framework.common.session;

import com.dbll.framework.common.protocol.AbstractPacket;

import io.netty.channel.Channel;

public class DefaultSession extends AbstractSession{
	
	private DefaultSession(Channel channel) {
		super(channel);
	}

	@Override
	public void sendMessage(AbstractPacket packet) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
	
	public static Session build(Channel channel){
		return new DefaultSession(channel);
	}

}
