package com.dbll.framework.common.app;

import org.springframework.context.annotation.Configuration;

import com.dbll.framework.common.netty.NettyServer;

@Configuration
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
