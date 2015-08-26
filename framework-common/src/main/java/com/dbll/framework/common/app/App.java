package com.dbll.framework.common.app;

import com.dbll.framework.common.netty.NettyServer;

public class App {
	
	public static void main(String[] args) {
		
		try {
			NettyServer server = new NettyServer(8080);
			server.startup();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
