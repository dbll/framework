package com.dbll.framework.common.command;

import com.google.protobuf.AbstractMessage;

public abstract class AbstractCommand implements Command {
	
	private int opCode;
	
	private AbstractMessage message; 
 	
	public int getOpCode(){
		return opCode;
	}

	public AbstractMessage getAbstractMessage(){
		return this.message;
	}
	
	public void setAbstractMessage(AbstractMessage message){
		this.message = message;
	}

	public abstract void excute();
	
}
