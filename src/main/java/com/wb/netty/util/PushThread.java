package com.wb.netty.util;

public class PushThread extends Thread {
	@Override
	public void run() {
		while (true) {
			System.out.println("信息推送开始");
			ChannelUtils.pushChannelMsgByAllUser("message push ok");
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
