package com.wb.netty.util;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.wb.netty.proto.service.SubReqServerHandle;
import com.wb.proto.entity.SubscribeResqProto;

import io.netty.buffer.ByteBuf;
import io.netty.channel.socket.SocketChannel;

public class ChannelUtils {
	public static final ConcurrentMap<String,SocketChannel> USER_CHANNEL = new ConcurrentHashMap<String,SocketChannel>();
	
	public static void addChannel(String userId,SocketChannel channel){
		USER_CHANNEL.put(userId, channel);
		
	}
	
	public static SocketChannel getChannel(String userId){
		return USER_CHANNEL.get(userId);
	}
	
	public static void pushChannelMsgByUserId(String userId,String message){
		try{
			SocketChannel channel = getChannel(userId);
			if(channel != null){
				SubReqServerHandle.resp(2);
				
				
				SubscribeResqProto.SubscribeResq message2= SubReqServerHandle.resp(2);
				
				
				channel.writeAndFlush(message2);
				System.out.println("pushChannelMsgByUserId:"+userId + "  message:"+message2);
			}else{
				System.out.println("Channel 不存在");
			}
		}catch(Exception e){
			
		};
	}
	
	public static void pushChannelMsgByAllUser(String message){
		Set<String> set = USER_CHANNEL.keySet();
		for(String userId:set){
			pushChannelMsgByUserId(userId,message);
		}
		if(set.size() == 0){
			System.out.println("当前用户为0");
		}else{
			System.out.println("pushChannelMsgByAllUser:"+message);
		}
		
		
	}
	
	
}
