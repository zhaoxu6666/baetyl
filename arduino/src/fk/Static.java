package fk;

import java.awt.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Static {
	static int t = 30;
	static int h = 30;
	static double a = 0.66;
	static int p = 150;
	static String pollution ="";
	static String fire ="";
	static int f = 800;
	static int t1 = 30;
	static int h1 = 30;
	static int t2 = 30;
	static int h2 = 30;
	static int t3 = 30;
	static int h3 = 30;
	static int t4 = 30;
	static int h4 = 30;
	static int t5 = 30;
	static int h5 = 30;
	
	static int getT(String name) {
		switch(name){
			case "1" :
				return t1;
			case "2" :
				return t2;
		    case "3" :
		    	return t3;
		    case "4" :
		    	return t4;
		    case "5" :
		    	return t5;
		}
		return t;
	}

	static int getH(String name) {
		switch(name){
			case "1" :
				return h1;
			case "2" :
				return h2;
		    case "3" :
		    	return h3;
		    case "4" :
		    	return h4;
		    case "5" :
		    	return h5;
		}
		return h;
	}

	static void setchange(String name) {
		switch(name){
			case "1" :
				t1=t;
				h1=h;
				break;
		    case "2" :
		    	t2=t;
				h2=h;
		    	break; //可选
		    case "3" :
		    	t3=t;
				h3=h;
		    	break;
		    case "4" :
		    	t4=t;
				h4=h;
		    	break;
		    case "5" :
		    	t5=t;
				h5=h;
		    	break;
		    //你可以有任意数量的case语句
		}
	}
	//改变气体污染检测的蜂鸣阈值
	static void changeP(){
		try {
			for (int i = 0;i<10;i++){
				System.out.println(Static.pollution);
				String str = "pollution:"+Static.pollution;
				DatagramSocket socket = new DatagramSocket();//创建Socket相当于创建码头
				DatagramPacket packet = new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName("192.168.0.112"), 8080);//192.168.0.112
				Robot r = new Robot();
				r.delay(800);
				socket.send(packet);//发货,将数据发出去
				System.out.println("已发送数据包PPPPP："+packet);
				socket.close();//关闭码头
			}
		}catch (Exception e){
			System.out.println("异常："+e);
		}
	}

	//改变火光检测的蜂鸣阈值
	static void changeF(){
		try {
			for (int i = 0;i<10;i++){
				System.out.println(Static.fire);
				String str = "fire:"+Static.fire;
				DatagramSocket socket = new DatagramSocket();//创建Socket相当于创建码头
				DatagramPacket packet = new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName("192.168.0.104"), 8080);
				Robot r = new Robot();
				r.delay(800);
				socket.send(packet);//发货,将数据发出去
				System.out.println("已发送数据包FFFFF："+packet);
				socket.close();//关闭码头
			}
		}catch (Exception e){
			System.out.println("异常："+e);
		}
	}
}
