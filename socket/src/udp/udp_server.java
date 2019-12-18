package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 2.接收Receive
 * 创建DatagramSocket, 指定端口号
 * 创建DatagramPacket, 指定数组, 长度
 * 使用DatagramSocket接收DatagramPacket
 * 关闭DatagramSocket
 * 从DatagramPacket中获取数据
 * @author ziv
 * @date 2019/12/13  9:48
 */
public class udp_server {

    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(6666);//创建Socket相当于创建码头
        DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);//创建Packet相当于创建集装箱
        socket.receive(packet);//接货,接收数据
        byte[] arr = packet.getData();//获取数据
        int len = packet.getLength();//获取有效的字节个数
        System.out.println("获得数据的长度是："+len);
        System.out.println(new String(arr, 0, len));
        socket.close();
    }

}
