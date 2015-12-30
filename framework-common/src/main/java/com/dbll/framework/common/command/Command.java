package com.dbll.framework.common.command;

import com.google.protobuf.AbstractMessage;

public interface Command extends Runnable{
	
	void setOpCode();
	
	int getOpCode();
	
	AbstractMessage getAbstractMessage();
	
	void setAbstractMessage(AbstractMessage message);

}