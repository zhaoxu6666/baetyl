import java.awt.*;

/**
 * @author ziv
 * @date 2019/12/18  11:11
 */
public class Static {
    static int i = 0;
    static void time(){
        while (true){
            System.out.println("已经入time函数");
            try {
                Robot r = new Robot();
                r.delay(10000);
                if (Static.i==1){
                    Static.i = 0;
                    continue;//这个是多余的
                }else {
                    break;
                }
            }catch (Exception e){
                System.out.println("timeInterrupted异常："+e);
            }
        }
        Static.i = 0; //调用setdata函数  使显示变为--
        System.out.println("时间已经到了"+Static.i);
    }
}
