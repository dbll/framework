package com.dbll.framework.common.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dbll.framework.common.session.Session;

public class Account {
	
	private static final Logger LOG = LoggerFactory.getLogger(Account.class);

	private final int accountId;
	
	private final Session session;
	
	public Account(int accountId, Session session) {
		this.accountId = accountId;
		this.session = session;
	}
	
	public void sendMessage(int opCode, byte[] data) {
		
		try {
			
			session.sendMessage(data);
			
		} catch (Exception e) {
			LOG.error("SEND MESSAGE " + opCode 
				+ " TO " + accountId + " FAILD!", e.fillInStackTrace());
		}
	}
	
}
