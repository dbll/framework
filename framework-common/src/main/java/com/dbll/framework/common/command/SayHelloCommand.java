package com.dbll.framework.common.command;

public class SayHelloCommand extends AbstractCommand{

	@Override
	public void setOpCode() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excute() {
		System.out.println("Hello!");
	}

}
