package fk;

import javax.swing.*;
import java.awt.*;

/**
 * @author ziv
 * @date 2019/12/26  14:35
 */
class Flicker implements Runnable{
    static String threadF1 = "";
    static String threadF2 = "";
    static String threadF3 = "";
    static String threadF4 = "";
    static String threadF5 = "";

    static int sensor1T = 0;
    static int sensor1H = 0;
    static int sensor1V = 0;
    static int sensor1L = 0;
    static int sensor2T = 0;
    static int sensor2H = 0;
    static int sensor2V = 0;
    static int sensor2L = 0;
    static int sensor3T = 0;
    static int sensor3H = 0;
    static int sensor3V = 0;
    static int sensor3L = 0;
    static int sensor4T = 0;
    static int sensor4H = 0;
    static int sensor4V = 0;
    static int sensor4L = 0;
    static int sensor5T = 0;
    static int sensor5H = 0;
    static int sensor5V = 0;
    static int sensor5L = 0;

    static JPanel jPanel1;
    static JPanel jPanel2;
    static JPanel jPanel3;
    static JPanel jPanel4;
    static JPanel jPanel5;

    String name;
    Flicker(String name){
        this.name = name;
    }
    @Override
    public void run(){
        try {
            Robot r = new  Robot();
            while (true){
//			System.out.println("已经入time函数"+location.getName());
                if (judge(name)){
                    confVisible(name);
                    r.delay(1000);
                    confDisvisible(name);
                    r.delay(500);
                }else {
                    Flicker.setThreadF(name,"");
                    break;
                }
            }
        }catch (Exception e){
            System.out.println("timeInterrupted异常："+e);
        }
        System.out.println("Flicker end");

    }

    static void setThreadF(String name,String threadName){
        switch(name){
            case "1" :
                threadF1 = threadName;
                break;
            case "2" :
                threadF2 = threadName;
                break;
            case "3" :
                threadF3 = threadName;
                break;
            case "4" :
                threadF4 = threadName;
                break;
            case "5" :
                threadF5 = threadName;
                break;
        }
    }

    static boolean judge(String name){
        switch(name){
            case "1" :
                if (Flicker.sensor1T==1 || Flicker.sensor1H==1 || Flicker.sensor1V==1 || Flicker.sensor1L==1){
                    return true;
                }
                return false;
            case "2" :
                if (Flicker.sensor2T==1 || Flicker.sensor2H==1 || Flicker.sensor2V==1 || Flicker.sensor2L==1){
                    return true;
                }
                return false;
            case "3" :
                if (Flicker.sensor3T==1 || Flicker.sensor3H==1 || Flicker.sensor3V==1 || Flicker.sensor3L==1){
                    return true;
                }
                return false;
            case "4" :
                if (Flicker.sensor4T==1 || Flicker.sensor4H==1 || Flicker.sensor4V==1 || Flicker.sensor4L==1){
                    return true;
                }
                return false;
            case "5" :
                if (Flicker.sensor5T==1 || Flicker.sensor5H==1 || Flicker.sensor5V==1 || Flicker.sensor5L==1){
                    return true;
                }
                return false;
        }
        return false;
    }

    static void setSensorT(String name,int attitude){
        switch(name){
            case "1" :
                sensor1T = attitude;
                break;
            case "2" :
                sensor2T = attitude;
                break;
            case "3" :
                sensor3T = attitude;
                break;
            case "4" :
                sensor4T = attitude;
                break;
            case "5" :
                sensor5T = attitude;
                break;
        }
    }

    static void setSensorH(String name,int attitude){
        switch(name){
            case "1" :
                sensor1H = attitude;
                break;
            case "2" :
                sensor2H = attitude;
                break;
            case "3" :
                sensor3H = attitude;
                break;
            case "4" :
                sensor4H = attitude;
                break;
            case "5" :
                sensor5H = attitude;
                break;
        }
    }

    static void setSensorV(String name,int attitude){
        switch(name){
            case "1" :
                sensor1V = attitude;
                break;
            case "2" :
                sensor2V = attitude;
                break;
            case "3" :
                sensor3V = attitude;
                break;
            case "4" :
                sensor4V = attitude;
                break;
            case "5" :
                sensor5V = attitude;
                break;
        }
    }

    static void setSensorL(String name,int attitude){
        switch(name){
            case "1" :
                sensor1L = attitude;
                break;
            case "2" :
                sensor2L = attitude;
                break;
            case "3" :
                sensor3L = attitude;
                break;
            case "4" :
                sensor4L = attitude;
                break;
            case "5" :
                sensor5L = attitude;
                break;
        }
    }

    static String getThreadAttitude(String name){
        switch(name){
            case "1" :
                return threadF1;
            case "2" :
                return threadF2;
            case "3" :
                return threadF3;
            case "4" :
                return threadF4;
            case "5" :
                return threadF5;
        }
        return "";
    }

    static void setjPanel1(JPanel jPanel){
        jPanel1 = jPanel;
    }
    static void setjPanel2(JPanel jPanel){
        jPanel2 = jPanel;
    }
    static void setjPanel3(JPanel jPanel){
        jPanel3 = jPanel;
    }
    static void setjPanel4(JPanel jPanel){
        jPanel4 = jPanel;
    }
    static void setjPanel5(JPanel jPanel){
        jPanel5 = jPanel;
    }

    //设置隐藏显示效果
    static void confVisible(String name){
        try {
            switch(name){
                case "1" :
                    jPanel1.setVisible(true);
                    break;
                case "2" :
                    jPanel2.setVisible(true);
                    break;
                case "3" :
                    jPanel3.setVisible(true);
                    break;
                case "4" :
                    jPanel4.setVisible(true);
                    break;
                case "5" :
                    jPanel5.setVisible(true);
                    break;
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //设置隐藏效果
    static void confDisvisible(String name){
        switch(name){
            case "1" :
                jPanel1.setVisible(false);
                break;
            case "2" :
                jPanel2.setVisible(false);
                break;
            case "3" :
                jPanel3.setVisible(false);
                break;
            case "4" :
                jPanel4.setVisible(false);
                break;
            case "5" :
                jPanel5.setVisible(false);
                break;
        }
    }


}