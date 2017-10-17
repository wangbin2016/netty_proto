package com.wb.netty.http.service;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.CharsetUtil;

import static io.netty.handler.codec.http.HttpResponseStatus.*;

import java.nio.ByteBuffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;




public class ServerHandler extends SimpleChannelInboundHandler<Object> {
	public static final String HONGBO_API_PATH = "com.hongbo.api.impl.";


	public void messageReceived(ChannelHandlerContext arg0, Object request) {
		System.out.println("messageReceived");
	}
	
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
    	System.out.println("channelActive");
    }

	public void exceptionCaught(ChannelHandlerContext arg0, Throwable arg1) throws Exception {
		System.out.println("exceptionCaught");
		arg1.printStackTrace();
	}

	public void handlerAdded(ChannelHandlerContext arg0) throws Exception {
		System.out.println("handlerAdded sss"); 

	}

	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		System.out.println("handlerRemoved");
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object req) throws Exception {
		System.out.println("channelRead0"+req.getClass());
		ByteBuf byteBuf = (ByteBuf)req;
		byte[] bytes = new byte[byteBuf.readableBytes()];
		byteBuf.readBytes(bytes);
		String content = new String(bytes);
		System.out.println("接收到数据是："+content);
		if("test".equals(content)){
			responseMsg(METHOD_NOT_ALLOWED, "test ok",ctx);
		}else{
			responseMsg(METHOD_NOT_ALLOWED, "哈哈哈。。。",ctx);
		}
		
	}
	
	public void responseMsg(HttpResponseStatus status,String msg,ChannelHandlerContext ctx) {
		System.out.println("向应数据"+msg);
		byte[] retMsg = msg.getBytes();
		ByteBuf byteBuffer = Unpooled.buffer(retMsg.length);
		byteBuffer.writeBytes(retMsg);
		ctx.writeAndFlush(byteBuffer);
	}
}
