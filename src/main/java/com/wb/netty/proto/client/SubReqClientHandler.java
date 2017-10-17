package com.wb.netty.proto.client;

import java.util.ArrayList;
import java.util.List;

import com.wb.proto.entity.SubscribeReqProto;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class SubReqClientHandler extends SimpleChannelInboundHandler<Object> {

	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		System.out.println("handlerAdded");
	}

	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		System.out.println("handlerRemoved");
	}

	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		System.out.println("exceptionCaught");
		cause.printStackTrace();
		ctx.close();
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("channelRead0");
		System.out.println("recive msg:"+msg);
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("channelActive");
		for(int i= 0;i<1;i++){
			ctx.write(subReq(i));
		}
		ctx.flush();
	}

	private SubscribeReqProto.SubscribeReq subReq(int i) {
		SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();
		builder.setSubReqID(i);
		builder.setProductName("game");
		builder.setSuserName("wb");
		List<String> list = new ArrayList<String>();
		list.add("gz");
		list.add("sz");
		builder.addAllAddress(list);
		return builder.build();
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		System.out.println("channelReadComplete");
		ctx.flush();
	}
	
	
	
	
	
	
	
	
	
	
	
}
