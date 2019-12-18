package udp;

import java.awt.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 1.发送Send
 * 创建DatagramSocket, 随机端口号
 * 创建DatagramPacket, 指定数据, 长度, 地址, 端口
 * 使用DatagramSocket发送DatagramPacket
 * 关闭DatagramSocket
 * @author ziv
 * @date 2019/12/13  9:49
 */
public class udp_client {

    public static void main(String[] args) throws Exception {
        for (int i = 0;i<10;i++){
            String str = "fire:"+"100";
            DatagramSocket socket = new DatagramSocket();//创建Socket相当于创建码头
            DatagramPacket packet = new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName("192.168.0.104"), 6666);//192.168.0.112
            Robot r = new Robot();
            r.delay(800);
            socket.send(packet);//发货,将数据发出去
            System.out.println("已发送数据包："+packet);
            socket.close();//关闭码头
        }
}
}