package fk;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//import java.net.ServerSocket;
//import java.net.Socket;

class DataUpdate implements Runnable{
    List<Location> locations;
    DatagramPacket receivePacket;
    DataUpdate(DatagramPacket receivePacket, List<Location> locations){
        this.receivePacket = receivePacket;
        this.locations = locations;
    }
    @Override
    public void run(){
        //String connectedIp = socket.getInetAddress().getHostAddress();
	InetAddress connectedIp = receivePacket.getAddress();
        System.out.println(connectedIp + " connected.....");


        Location location = null;

        for(Location location1: locations){
            //System.out.println("ip:"+connectedIp+"ip");
	    //System.out.println("ip:"+location1.getIp()+"ip");
	    if(location1.getIp().equals(""+connectedIp)){               
		location = location1;
                break;
            }
        }
        //System.out.println(location.getLocation + " location connected.....");

        if(location == null) return;

        InputStream inputStream = null;
        //try {
        //    inputStream = socket.getInputStream();
        //}catch (IOException e){e.printStackTrace();return;}

	String sentence = new String(receivePacket.getData());
        //BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String name=location.getName();
        //try {
            //sensorId = Integer.parseInt(br.readLine());
		//一个子节点的所有传感器的数据

        switch (name) {
		case "1":
			setUp1(location,name,sentence);
			break;
		case "2":
			setUp2(location,name,sentence);
			break;
		case "3":
			setUp3(location,name,sentence);
			break;
		case "4":
			setUp4(location,name,sentence);
			break;
		case "5":
			setUp1(location,name,sentence);
			break;
		default:
			break;
		}
        //}catch (Exception e){e.printStackTrace(); return;}
        
    }
    
    //
    public void setUp1(Location location,String name,String sentence) {
		TH(location,name,sentence);
		V(location,name,sentence);
		L(location,name,sentence);
    }
    
    //SO
    public void setUp2(Location location,String name,String sentence) {
		TH(location,name,sentence);
		L(location,name,sentence);
		String[] ss = sentence.split("\n");
		int sensorId3 = Integer.parseInt(ss[4]);
		String data3 = ss[5];
        if(sensorId3 == Sensors.VOLSENSOR.getId()){
        	if(Double.parseDouble(data3)<Static.a) {
        		location.getVolField().setForeground(Color.BLACK);
        		location.getVolField().setText(data3);
        	}else {
        		location.getVolField().setForeground(Color.RED);
        		location.getVolField().setText(data3);
        	}
        }

    }

    public void setUp3(Location location,String name,String sentence) {
		TH(location,name,sentence);
		String[] ss = sentence.split("\n");
		int sensorId2 = Integer.parseInt(ss[4]);
		String data2 = ss[5];
		int sensorId3 = Integer.parseInt(ss[6]);
		String data3 = ss[7];
        if(sensorId2 == Sensors.VOLSENSOR.getId()){   //烟雾模块
        	if(Integer.parseInt(data2)<Static.p) {
        		location.getVolField().setForeground(Color.BLACK);
        		location.getVolField().setText(data2);
        	}else {
        		location.getVolField().setForeground(Color.RED);
        		location.getVolField().setText(data2);
        	}
        }
        if(sensorId3 == Sensors.LIGSENSOR.getId()){   //震动模块
        	if(Integer.parseInt(data3)==1) {
        		data3 = "警告";
        		location.getLigField().setForeground(Color.RED);
        		location.getLigField().setText(data3);
        	}else {
        		data3 = "正常";
        		location.getLigField().setForeground(Color.BLACK);
        		location.getLigField().setText(data3);
        	}
        }
    }
    
    public void setUp4(Location location,String name,String sentence) {
    	TH(location,name,sentence);
		V(location,name,sentence);
		String[] ss = sentence.split("\n");
		int sensorId3 = Integer.parseInt(ss[6]);
		String data3 = ss[7];
    	if(sensorId3 == Sensors.LIGSENSOR.getId()){  //火光模块
    		if(Integer.parseInt(data3)>Static.f) {
    			location.getLigField().setForeground(Color.RED);
    			location.getLigField().setText(data3);
    		}else {
    			location.getLigField().setForeground(Color.BLACK);
    			location.getLigField().setText(data3);
    		}
    	}
    }

	public void TH(Location location,String name,String sentence) {
		String[] ss = sentence.split("\n");
		int sensorId = Integer.parseInt(ss[0]);
		String data = ss[1];
		int sensorId1 = Integer.parseInt(ss[2]);
		String data1 = ss[3];

		if (sensorId == Sensors.TEMPSENSOR.getId()) {
			if (Integer.parseInt(data) < Static.getT(name)) {
				location.getTempField().setForeground(Color.BLACK);
				location.getTempField().setText(data);
			} else {
				location.getTempField().setForeground(Color.RED);
				location.getTempField().setText(data);
			}
		}
		if (sensorId1 == Sensors.HUMSENSOR.getId()) {
			System.out.println(Sensors.HUMSENSOR.getId());
			if (Integer.parseInt(data1) < Static.getH(name)) {
				location.getHumField().setForeground(Color.BLACK);
				location.getHumField().setText(data1);
			} else {
				location.getHumField().setForeground(Color.RED);
				location.getHumField().setText(data1);
			}
		}
	}
	public void V(Location location,String name,String sentence) {
		String[] ss = sentence.split("\n");
		int sensorId2 = Integer.parseInt(ss[4]);
		String data2 = ss[5];
		if(sensorId2 == Sensors.VOLSENSOR.getId()) {  //噪音模块
			if (Integer.parseInt(data2) == 0) {
				data2 = "正常";
				location.getVolField().setForeground(Color.BLACK);
				location.getVolField().setText(data2);
			} else {
				data2 = "警告";
				location.getVolField().setForeground(Color.RED);
				location.getVolField().setText(data2);
			}
		}
	}
	public void L(Location location,String name,String sentence) {
		String[] ss = sentence.split("\n");
		int sensorId3 = Integer.parseInt(ss[6]);
		String data3 = ss[7];
		if(sensorId3 == Sensors.LIGSENSOR.getId()){
			if(Integer.parseInt(data3)==0) {
				data3 = "警告";
				location.getLigField().setForeground(Color.RED);
				location.getLigField().setText(data3);
			}else {
				data3 = "正常";
				location.getLigField().setForeground(Color.BLACK);
				location.getLigField().setText(data3);
			}
		}
	}

}


public class SensorServer {
    static List getSensors(Map<String, JComponent> tempHashMap, Map<String, JComponent> humHashMap,
                           Map<String, JComponent> volHashMap, Map<String, JComponent> ligHashMap) throws NullPointerException{
        List<Location> sensors = new ArrayList<>();
        JTextField tempField = null, humField = null, volField = null, ligField = null;
        for(Locations sensors1: Locations.values()){
            for(String key: tempHashMap.keySet()){
                //System.out.println(key);
                if(sensors1.getName().equals(key)){
                    //System.out.println("equal!");
                    tempField = (JTextField)tempHashMap.get(key);
                    humField = (JTextField)humHashMap.get(key);
                    volField = (JTextField)volHashMap.get(key);
                    ligField = (JTextField)ligHashMap.get(key);
                    break;
                }
            }
            if(tempField == null || humField == null || volField == null || ligField == null) throw
                    new NullPointerException("filed null! " + sensors1.getName());
            sensors.add(new Location(sensors1.getName(), sensors1.getLocation(), sensors1.getIp(),
                    tempField, humField, volField, ligField));
        }
        return Collections.unmodifiableList(sensors);
    }


    public static void main(String[] args) throws IOException {
        JFramDemo jf = JFramDemo.getInstance();
        Map<String, JComponent> tempHashmap = (Map<String, JComponent>)jf.getTempHashMap();
        Map<String, JComponent> humHashMap = (Map<String, JComponent>)jf.getHumiHashmap();
        Map<String, JComponent> volHashMap = (Map<String, JComponent>)jf.getVolHashMap();
        Map<String, JComponent> ligHashMap = (Map<String, JComponent>)jf.getLigHashMap();

        List<Location> locations = getSensors(tempHashmap, humHashMap, volHashMap, ligHashMap);

         for(Location sensor: locations){
            System.out.println(sensor+"((((((((((");
        }

        ExecutorService executorService = Executors.newSingleThreadExecutor();  //线程池

        //ServerSocket serverSocket = new ServerSocket(1234);
        //Socket socket = null;
	
        DatagramSocket serverSocket1 = new DatagramSocket(1234);  //UDP连接 并监听1234端口

        System.out.println("start...");

        while (true){
            //socket = serverSocket.accept();
            byte[] receiveData = new byte[1024];

//	    System.out.println(receiveData.length);

	    DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length); //设置数据包的大小

	    serverSocket1.receive(receivePacket); //接收数据包从这个socket
	    
	    System.out.println("received UDP");

	    executorService.execute(new DataUpdate(receivePacket, locations));  

	    //System.out.println("received done!");

        }
    }
}
