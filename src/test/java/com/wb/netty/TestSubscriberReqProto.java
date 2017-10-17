package com.wb.netty;

import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.InvalidProtocolBufferException;
import com.wb.proto.entity.SubscribeReqProto;

public class TestSubscriberReqProto {
	private static byte[] encode(SubscribeReqProto.SubscribeReq req){
		return req.toByteArray();
	}
	
	private static SubscribeReqProto.SubscribeReq decode(byte[] body) throws InvalidProtocolBufferException{
		return SubscribeReqProto.SubscribeReq.parseFrom(body);
	}
	
	private static SubscribeReqProto.SubscribeReq createSubscribeReq(){
		SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();
		builder.setSubReqID(1);
		builder.setSuserName("wb");
		builder.setProductName("game j001");
		
		List<String> address = new ArrayList<String>();
		address.add("bj");
		address.add("gz");
		address.add("sh");
		builder.addAllAddress(address);
		return builder.build();
	}
	
	public static void main(String[] args) throws InvalidProtocolBufferException {
		SubscribeReqProto.SubscribeReq req = createSubscribeReq();
		System.out.println(req.toString());
		SubscribeReqProto.SubscribeReq req2 = decode(encode(req));
		System.out.println(req2.toString());
	}
	
}
