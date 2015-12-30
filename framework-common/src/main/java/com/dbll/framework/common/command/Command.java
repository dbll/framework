package com.dbll.framework.common.command;

import com.google.protobuf.AbstractMessage;

public interface Command {
	
	void setOpCode();
	
	int getOpCode();
	
	AbstractMessage getAbstractMessage();
	
	void setAbstractMessage(AbstractMessage message);

	void excute();
	
}