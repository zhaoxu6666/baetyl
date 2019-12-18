package fk;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
//import java.net.Socket;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class FakeSendData implements Runnable{
    float data;
    int sensor;

    FakeSendData(float data, int sensor){
        this.data = data;
        this.sensor = sensor;
    }

    @Override
    public void run() {
        try {
            //Socket socket = new Socket("127.0.0.1", 1234);
            //OutputStream os = socket.getOutputStream();
	    
            DatagramSocket socket = new DatagramSocket();
	    InetAddress IPAddress = InetAddress.getByName("127.0.0.1");	    
	    byte[] sendData = new byte[1024];

	    String abc = sensor+"\n"+data+"\n";

            //PrintWriter printWriter = new PrintWriter(os);

            //printWriter.write(sensor+"\n"+data);
            //printWriter.flush();

	    sendData = abc.getBytes();

	    DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,9878);

            //socket.shutdownOutput();
            //socket.shutdownInput();
	    
  	    socket.close();
            //os.close();
            //printWriter.close();
            //socket.close();
        }catch (Exception e){
    //        e.printStackTrace();
        }
    }
}
public class SensorClient {
    public static void main(String[] args) throws InterruptedException {
        float[] datas = {
             12.23f,
             15.22f,
             16.22f,
             177.21f,
             16.21f,
             1223f,
             142.11f
        };
        int [] sensors = {
            0,
            1,
            2,
            3
        };

        Random random = new Random();
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for(int i=0;i<1000;i++){
            float data = datas[random.nextInt(datas.length)];
            int sensor = sensors[random.nextInt(sensors.length)];
            executorService.execute(new FakeSendData(data, sensor));

            Thread.sleep(1000);
        }
    }
}
