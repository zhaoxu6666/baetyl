import java.util.Stack;

public class zhan {
	public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>(); //首先创建一个栈的对象
        for(int i = 0; i < tokens.length ; i++){
             try{
                 int num = Integer.parseInt(tokens[i]);
                 stack.add(num);
             }catch(Exception e){
                 int a = stack.pop();
                 int b = stack.pop();
                 stack.add(get(a,b,tokens[i]));
             }
        }
        return stack.pop();        
    }
    public int get(int a,int b,String token){
        switch(token){
            case "+" :
                return a+b;
            case "-" :
                return b-a;
            case "*" :
                return a*b;
            case "/" :
                return b/a;
            default:
                return 0;
        }
    }
    public static void main(String[] args) {
    	String[] l = {"2", "1", "+", "3", "*"};
    	zhan z = new zhan();
    	System.out.println(z.evalRPN(l));
    }
}
