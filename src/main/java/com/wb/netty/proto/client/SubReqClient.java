package com.wb.netty.proto.client;

import com.wb.proto.entity.SubscribeResqProto;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

public class SubReqClient {
	public void connect(int port,String host){
		EventLoopGroup group = new NioEventLoopGroup();
		try{
			Bootstrap b = new Bootstrap();
			b.group(group);
			b.option(ChannelOption.TCP_NODELAY, true);
			b.channel(NioSocketChannel.class);
	        b.option(ChannelOption.SO_KEEPALIVE,true);
	        
			b.handler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(new ProtobufVarint32FrameDecoder());
					ch.pipeline().addLast(new ProtobufDecoder(SubscribeResqProto.SubscribeResq.getDefaultInstance()));
					ch.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
					ch.pipeline().addLast(new ProtobufEncoder());
					ch.pipeline().addLast(new SubReqClientHandler());
				}
			});
			ChannelFuture f = b.connect(host,port).sync();
			System.out.println("联接成功!");
			f.channel().closeFuture().sync();
			System.out.println("关闭联接成功!");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			group.shutdownGracefully();
		}
	}
	
	public static void main(String[] args) {
		SubReqClient client = new SubReqClient();
		client.connect(41186, "wxjwb.nat123.net");
	}
}
