package fk;

import java.awt.*;

/**
 * @author ziv
 * @date 2019/12/26  17:18
 */
class Detect implements Runnable{
    static int i1 = 0;
    static String thread1 = "";
    static int i2 = 0;
    static String thread2 = "";
    static int i3 = 0;
    static String thread3 = "";
    static int i4 = 0;
    static String thread4 = "";
    static int i5 = 0;
    static String thread5 = "";



    Location location;
    String name;
    Detect(Location location, String name){
        this.location = location;
        this.name = name;
    }
    @Override
    public void run(){
        try {
            Robot r = new  Robot();
            while (true){
//			System.out.println("已经入time函数"+location.getName());
                r.delay(10000);
                if (getI(name)==1){
                    setI(name,0);
                }else {
                    break;
                }
            }
        }catch (Exception e){
            System.out.println("timeInterrupted异常："+e);
        }
        setI(name,0); //调用setdata函数  使显示变为--
        setThread(name,"");
        location.getTempField().setText("--");
        location.getHumField().setText("--");
        location.getVolField().setText("--");
        location.getLigField().setText("--");
        if (Flicker.judge(name)){
            Flicker.setSensorT(name,0);
            Flicker.setSensorH(name,0);
            Flicker.setSensorV(name,0);
            Flicker.setSensorL(name,0);
        }
//		System.out.println("时间已经到了"+Static.getT(name)+location.getName());
    }


    static void setThread(String name,String threadName){
        switch(name){
            case "1" :
                thread1 = threadName;
                break;
            case "2" :
                thread2 = threadName;
                break;
            case "3" :
                thread3 = threadName;
                break;
            case "4" :
                thread4 = threadName;
                break;
            case "5" :
                thread5 = threadName;
                break;
        }
    }

    static void setI(String name,int i){
        switch(name){
            case "1" :
                i1 = i;
                break;
            case "2" :
                i2 = i;
                break;
            case "3" :
                i3 = i;
                break;
            case "4" :
                i4 = i;
                break;
            case "5" :
                i5 = i;
                break;
        }
    }

    static int getI(String name){
        switch(name){
            case "1" :
                return i1;
            case "2":
                return i2;
            case "3":
                return i3;
            case "4" :
                return i4;
            case "5" :
                return i5;
        }
        return i1;
    }
}
