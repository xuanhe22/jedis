package com.game.redis.service;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class HeartHandler extends ChannelInboundHandlerAdapter {

	private int counter;
	static final String ECHO_REQ = "Hi, Lilinfeng. Welcome to Netty.$_";
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
	
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		if (IdleStateEvent.class.isAssignableFrom(evt.getClass())) {
			IdleStateEvent event = (IdleStateEvent) evt;
			if (event.state() == IdleState.READER_IDLE)
				System.out.println("read idle");
			else if (event.state() == IdleState.WRITER_IDLE)
				System.out.println("write idle");
			else if (event.state() == IdleState.ALL_IDLE)
				System.out.println("all idle");
		}
	}
}
