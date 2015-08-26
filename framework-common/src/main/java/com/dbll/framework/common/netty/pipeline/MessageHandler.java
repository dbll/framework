package com.dbll.framework.common.netty.pipeline;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

public class MessageHandler extends ChannelHandlerAdapter{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		
		ByteBuf in = (ByteBuf) msg;
		
		try {
	        // Do something with msg
			
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
		 final ByteBuf time = ctx.alloc().buffer(4); // (2)
	        time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));

	        final ChannelFuture f = ctx.writeAndFlush(time); // (3)
	        f.addListener(new ChannelFutureListener() {

	            public void operationComplete(ChannelFuture future) {
	                assert f == future;
	                ctx.close();
	            }
	        }); // (4)
	}

	
	
}
