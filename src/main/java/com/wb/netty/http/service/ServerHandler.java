package com.wb.netty.http.service;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.CharsetUtil;

import static io.netty.handler.codec.http.HttpResponseStatus.*;

import io.netty.buffer.Unpooled;




public class ServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
	public static final String HONGBO_API_PATH = "com.hongbo.api.impl.";


	public void messageReceived(ChannelHandlerContext arg0, FullHttpRequest request) {
		System.out.println("messageReceived");
	}
	
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
    	System.out.println("channelActive");
    	//ChannelUtils.addChannel("channelActive", ctx.channel());
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
	protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest req) throws Exception {
		System.out.println("channelRead0");
		/*if (!req.decoderResult().isSuccess()) {
			responseMsg(BAD_REQUEST, null,ctx);
			return;
		}
		if (req.method() != HttpMethod.POST) {
			responseMsg(METHOD_NOT_ALLOWED, null,ctx);
			return;
		}*/
		/*String uri = req.uri();
		uri = uri.substring(1, uri.length());
		String[] params = uri.split("\\?");
		String uriName = params[0];*/
	
		responseMsg(METHOD_NOT_ALLOWED, "响应客户端OK",ctx);
	}
	
	public void responseMsg(HttpResponseStatus status,String msg,ChannelHandlerContext ctx) {
		String content = "Failure:" + status.toString() + "\r\n";
		if(msg != null && msg.length()!=0){
			content = msg;
		}

		System.out.println("响应客户端信息:"+content);
		FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, status,
				Unpooled.copiedBuffer(content, CharsetUtil.UTF_8));
		response .headers().set("content_type", "text/plain");
		response .headers().set("charset", "utf-8");
		ctx.writeAndFlush(response);
	}
}
