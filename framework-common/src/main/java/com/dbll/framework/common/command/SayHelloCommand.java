package com.dbll.framework.common.command;

import com.dbll.framework.common.annotation.Command;
import com.dbll.framework.common.constant.ChannelState;

@Command(commandCode = 0x001, state = ChannelState.RUNNING, commandDesc = "hello test")
public class SayHelloCommand extends AbstractCommand{

	@Override
	public void setOpCode() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		System.out.println("Hello!");
	}

}
