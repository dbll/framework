package com.dbll.framework.common.session;

import java.util.Map;

import com.dbll.framework.common.session.Session.Status;
import com.google.common.collect.Maps;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.ChannelMatcher;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.DefaultEventExecutor;

public class SessionGroup {
	
	public final static String DEFAULT_NAME = "DEFAULT_GROUP";
	
	public static final ChannelGroup ALL_CHANNELS = new DefaultChannelGroup(DEFAULT_NAME, new DefaultEventExecutor());
	
	public static Map<Integer, Session> ACCOUNT_SESSION_MAP = Maps.newHashMap();
	
	
	/**
	 * send the message to the channel
	 * @param message
	 */
	public void notifyAll(byte[] message){
		
		ChannelMatcher matcher = new ChannelMatcher() {
			
			@Override
			public boolean matches(Channel channel) {
				return channel.isActive();
				
			}
		};
		
		ALL_CHANNELS.writeAndFlush(message, matcher);
	}

	/**
	 * get the account session
	 * @param accountId
	 * @return session
	 */
	public Session getSession(int accountId){
		
		Session session = ACCOUNT_SESSION_MAP.get(accountId);
		
		if (session != null) {
			
			Status status = session.getStatus();
			
			if (status == Status.NOT_CONNECTED || status == Status.CLOSED) {
				ACCOUNT_SESSION_MAP.remove(accountId);
				session = null;
			}
		}
		
		return session;
	}
	
}
