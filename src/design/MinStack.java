package design;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;
    private Integer min;

    private MinStack(){
        stack = new Stack<>();
    }

    private  void push(Integer val){
        if(stack.isEmpty()){
            min = val;
            stack.push(val);
            System.out.println("value inserted is: " +val);
        }
        else{
            if(val < min){
                stack.push(2*val-min);
                min = val;
            }
            else {
                stack.push(val);
            }
            System.out.println("value inserted is : " + val);
        }
    }

    private  void getMin(){
        if(stack.isEmpty()){
            System.out.println("stack is empty");
        }
        else{
            System.out.println("min value is:" +min);
        }
    }
    private  void pop(){
        if(stack.isEmpty()){
            System.out.println("stack is  empty");
            return;
        }
        else{
            Integer temp = stack.pop();
            if(min < temp){
                System.out.println("value poped is: " + temp);
            }
            else{
                System.out.println("value poped is:"+min);
                min = 2*min -temp;
            }

        }
    }

    private static  void test(int val){
        if(val == 1){
            System.out.println("1");
        }
        else{
            System.out.println("not 1");
        }
        System.out.println("test");
    }
    private  void peek(){
        if (stack.isEmpty()){
            System.out.println("stack is empty");
        }
        else{
            Integer temp = stack.peek();
            if(temp < min){
                System.out.println("value peek is: " + min);
            }
            else
                System.out.println("value peek is: " +temp);
        }
    }


    public static void main(String[] args) {
        MinStack st = new MinStack();
        st.push(3);
        st.push(5);
        st.getMin();
        st.push(2);
        st.push(1);
        st.getMin();
        st.pop();
        st.getMin();
        st.pop();
        st.peek();
        test(2);
    }
}
