/**
 * @author ziv
 * @date 2019/12/18  10:22
 */
public interface Interrupt {
    public static void main(String[] args){
        if(Static.i == 0){
            Static.time();
        }else {
            Static.i = 1;
        }
    }
}
