package com.wb.netty.http.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO客户端
 * 
 */
public class NIOClient implements Runnable{
	// 通道管理器
	private String host;
	private int port;
	private Selector selector;
	private SocketChannel socketChannel;
	private volatile boolean stop;

	/**
	 * 获得一个Socket通道，并对该通道做一些初始化的工作
	 * 
	 * @param ip
	 *            连接的服务器的ip
	 * @param port
	 *            连接的服务器的端口号
	 * @throws IOException
	 */
	public void initClient(String ip, int port) throws IOException {
		this.host = ip;
		this.port = port;
		// 获得一个Socket通道
		socketChannel = SocketChannel.open();
		// 设置通道为非阻塞
		socketChannel.configureBlocking(false);
		// 获得一个通道管理器
		selector = Selector.open();
		/*// 客户端连接服务器,其实方法执行并没有实现连接，需要在listen（）方法中调
		// 用channel.finishConnect();才能完成连接
		socketChannel.connect(new InetSocketAddress(ip, port));
		// 将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_CONNECT事件。
		socketChannel.register(selector, SelectionKey.OP_CONNECT);*/
	}

	

	/**
	 * 启动客户端测试
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		NIOClient client = new NIOClient();
		client.initClient("wxjwb.nat123.net", 41186);
	    new Thread(client).start();
		//client.listen();
	}

	/**
	 * 处理读取服务端发来的信息 的事件
	 * 
	 * @param key
	 * @throws IOException
	 */
	public void read(SelectionKey key) throws IOException {
		// 服务器可读取消息:得到事件发生的Socket通道
		SocketChannel channel = (SocketChannel) key.channel();
		// 创建读取的缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(10);
		channel.read(buffer);
		byte[] data = buffer.array();
		String msg = new String(data).trim();
		System.out.println("信息：" + msg);
		ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
		channel.write(outBuffer);// 将消息回送给客户端
	}
	
	public void read(SocketChannel channel) throws IOException {
		// 服务器可读取消息:得到事件发生的Socket通道
		// 创建读取的缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(1);
		channel.read(buffer);
		byte[] data = buffer.array();
		if(data != null && data.length >2){
			String msg = new String(data).trim();
			System.out.println("信息：" + msg);
			ByteBuffer outBuffer = ByteBuffer.wrap(("ok---"+msg).getBytes());
			channel.write(outBuffer);// 将消息回送给客户端
			
		}
	}

	public void run() {
		try{
			doConnect();
		}catch(Exception e){
			e.printStackTrace();
		}
		while(!stop){
			try{
				selector.select(1000);
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> it = selectedKeys.iterator();
				SelectionKey key = null;
				
				while(it.hasNext()){
					key = it.next();
					it.remove();
					try{
						handleInput(key);
					}catch(Exception e){
						e.printStackTrace();
						if(key != null){
							key.cancel();
							if(key.channel() != null){
								key.channel().close();
							}
						}
					}
				}
			}catch(Exception e){
				e.printStackTrace();
				
			}
			
		}
		
		if(selector != null){
			try{
				selector.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	private void handleInput(SelectionKey key) throws IOException {
		if(key.isValid()){
			SocketChannel sc = (SocketChannel) key.channel();
			if(key.isConnectable()){
				if(sc.finishConnect()){
					sc.register(selector, SelectionKey.OP_READ);
					doWrite(sc);
				}else{
					System.exit(1);
				}
			}
			
			if(key.isReadable()){
				ByteBuffer readBuffer = ByteBuffer.allocate(1024);
				int readByte = sc.read(readBuffer);
				if(readByte > 0){
					readBuffer.flip();
					byte[] bytes = new byte[readBuffer.remaining()];
					readBuffer.get(bytes);
					String body = new String(bytes,"utf-8");
					System.out.println("服务器返回："+body);
				}
				
			}
			
		}
	}

	private void doConnect() {
		try {
			if(socketChannel.connect(new InetSocketAddress(host, port))){
				socketChannel.register(selector, SelectionKey.OP_READ);
				doWrite(socketChannel);
			}else{
				socketChannel.register(selector, SelectionKey.OP_CONNECT);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void doWrite(SocketChannel sc) throws IOException {
		byte[] req = "test".getBytes();
		ByteBuffer wBuf = ByteBuffer.allocate(req.length);
		wBuf.put(req);
		wBuf.flip();
		sc.write(wBuf);
		if(!wBuf.hasRemaining()){
			System.out.println("sund 2 server succeed");
		}
	}

}
