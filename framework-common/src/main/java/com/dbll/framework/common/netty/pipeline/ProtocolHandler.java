package com.dbll.framework.common.netty.pipeline;

import com.dbll.framework.common.session.DefaultSession;
import com.dbll.framework.common.session.Session;
import com.dbll.framework.common.session.SessionGroup;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;

public class ProtocolHandler extends ChannelHandlerAdapter{
	
	private Session session;

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		
		ByteBuf in = (ByteBuf) msg;
		
		try {
			
			while (in.isReadable()) { // (1)
				System.out.print((char) in.readByte());
				System.out.flush();
			}
			
	    } finally {
	        ReferenceCountUtil.release(msg);
	    }
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

	@Override
	public void channelActive(final ChannelHandlerContext ctx) throws Exception {
		
		 SessionGroup.ALL_CHANNELS.add(ctx.channel());
		 
		 session = DefaultSession.build(ctx.channel());
		 
	}

	@Override
	public void close(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
		super.close(ctx, promise);
		session = null;
	}

	public Session getSession(){
		return session;
	}
	
}
