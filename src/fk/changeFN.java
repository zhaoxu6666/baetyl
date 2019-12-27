package fk;

import java.awt.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author ziv
 * @date 2019/12/26  16:55
 */
//改变气体污染检测的蜂鸣阈值
class changePollution implements Runnable{
    @Override
    public void run(){
        try {
            for (int i = 0;i<10;i++){
                System.out.println(Static.pollution);
                String str = "pollution:"+Static.pollution;
                DatagramSocket socket = new DatagramSocket();//创建Socket相当于创建码头
                DatagramPacket packet = new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName("192.168.0.112"), 8080);//192.168.0.112
                Robot r1 = new Robot();
                r1.delay(500);
                socket.send(packet);//发货,将数据发出去
                System.out.println("已发送数据包PPPPP："+packet);
                socket.close();//关闭码头
            }
        }catch (Exception e){
            System.out.println("异常："+e);
        }
    }
    static void changeP(){
        changePollution c = new changePollution();
        Thread t1 = new Thread(c);
        t1.start();
        System.out.println(t1.getName()+"PPPPPPPPPPPPPPPPPPPPPPPPPP");
    }
}

//改变火光检测的蜂鸣阈值
class changeFire implements Runnable{
    @Override
    public void run(){
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
    static void changeF(){
        changeFire c = new changeFire();
        Thread t1 = new Thread(c);
        t1.start();
        System.out.println(t1.getName()+"FFFFFFFFFFFFFFFFFFFFFFF");
    }
}
