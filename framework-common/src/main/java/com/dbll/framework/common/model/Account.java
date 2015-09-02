package com.dbll.framework.common.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dbll.framework.common.protocol.AbstractPacket;
import com.dbll.framework.common.session.Session;

public class Account {
	
	private static final Logger LOG = LoggerFactory.getLogger(Account.class);

	private final int accountId;
	
	private final Session session;
	
	public Account(int accountId, Session session) {
		this.accountId = accountId;
		this.session = session;
	}
	
	public void sendMessage(AbstractPacket packet) {
		
		try {
			
			session.sendMessage(packet);
			
		} catch (Exception e) {
			LOG.error("SEND MESSAGE " + packet.getOpCode() 
				+ " TO " + accountId + " FAILD!", e.fillInStackTrace());
		}
	}
	
}
