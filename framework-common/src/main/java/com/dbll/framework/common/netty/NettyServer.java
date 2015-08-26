package com.dbll.framework.common.netty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dbll.framework.common.netty.pipeline.MessageHandler;
import com.dbll.framework.common.server.Server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.DefaultEventExecutor;

public class NettyServer implements Server {
	
	private final static Logger LOG = LoggerFactory.getLogger(NettyServer.class);
	
	public static final ChannelGroup ALL_CHANNELS = new DefaultChannelGroup("SEVER_CHANNELS", new DefaultEventExecutor());

	protected int bindPort;

	protected final EventLoopGroup bossGroup = new NioEventLoopGroup();
	protected final EventLoopGroup workerGroup = new NioEventLoopGroup();
	
	protected ServerBootstrap BootStrap;
	
	protected ChannelFuture channelFuture;
	
	public NettyServer(int bindPort) {
		this.bindPort = bindPort;
	}

	@Override
	public void shutdown() throws InterruptedException {
		
		try{
			channelFuture.channel().closeFuture().sync();
			
			LOG.info("NETTY SERVER SHUTDOWN!");
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}

	@Override
	public void startup() throws InterruptedException {

		BootStrap = new ServerBootstrap();
		BootStrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
				.childHandler(new ChannelInitializer<SocketChannel>() {
					
					@Override
					public void initChannel(SocketChannel ch) throws Exception {
						
						ch.pipeline().addLast(new MessageHandler());
						
					}
					
				})
				
				.option(ChannelOption.SO_BACKLOG, 128)
				
				.childOption(ChannelOption.SO_KEEPALIVE, true)
				.childOption(ChannelOption.TCP_NODELAY, true);
		
		channelFuture = BootStrap.bind(bindPort).sync();
		
		LOG.info("NETTY SERVER STARTED!");
	}

	@Override
	public int getBindPort() {
		return bindPort;
	}

	@Override
	public TransmissionProtocol getTransmissionProtocol() {
		return TRANSMISSION_PROTOCOL.TCP;
	}
}
