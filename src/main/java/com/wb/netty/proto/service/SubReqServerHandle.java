package com.wb.netty.proto.service;

import java.util.concurrent.atomic.AtomicInteger;

import com.wb.netty.util.ChannelUtils;
import com.wb.proto.entity.SubscribeReqProto;
import com.wb.proto.entity.SubscribeResqProto;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;

public class SubReqServerHandle extends SimpleChannelInboundHandler<Object> {
private static final AtomicInteger userId = new AtomicInteger();
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable arg1) throws Exception {
		System.out.println("exceptionCaught");
		ctx.close();
	}

	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
	
	}

	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		System.out.println("handlerRemoved");
	}

	public void channelRead(ChannelHandlerContext ctx) throws Exception {
		System.out.println("handlerRemoved");
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
		int no = userId.incrementAndGet();
		System.out.println("handlerAdded"+no);
		ChannelUtils.addChannel("channelActive"+no, (SocketChannel)ctx.channel());
		
		SubscribeReqProto.SubscribeReq req = (SubscribeReqProto.SubscribeReq)msg;
		System.out.println("---------------------接收的数据-----start---------------");
		System.out.println(req);
		System.out.println("---------------------接收的数据-----end---------------");
		SubscribeResqProto.SubscribeResq resp = resp(req.getSubReqID());
		System.out.println("---------------------回写的数据-----start---------------");
		System.out.println(resp);
		ctx.writeAndFlush(resp);
		System.out.println("---------------------回写的数据-----end---------------");
	}
	
	public static SubscribeResqProto.SubscribeResq resp(int subReqId){
		 SubscribeResqProto.SubscribeResq.Builder  builder = SubscribeResqProto.SubscribeResq.newBuilder();
		 builder.setDesc("ok");
		 builder.setRespCode(200);
		 builder.setSubReqID(subReqId);
		 return builder.build();
	}
}
