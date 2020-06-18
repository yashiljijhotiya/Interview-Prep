import java.util.Stack;

public class StackOrderOne {

    private Stack<Integer> s;
    private Integer min;

    private StackOrderOne(){
        s = new Stack<>();
    }

    private void push(Integer val){
        if(s.isEmpty()){
          min = val;
          s.push(val);
            System.out.println("value inserted is: " +val);
        }
        else{
            if(val < min){
                s.push(2*val-min);
                min = val;
            }
            else {
                s.push(val);
            }
            System.out.println("value inserted is : " + val);
        }
    }

    private  void getMin(){
     if(s.isEmpty()){
         System.out.println("stack is empty");
     }
     else{
         System.out.println("min value is:" +min);
     }
    }

    private  void pop(){
        if(s.isEmpty()){
            System.out.println("stack is  empty");
            return;
        }
        else{
          Integer temp = s.pop();
          if(min < temp){
              System.out.println("value popped is: " + temp);
          }
          else{
              System.out.println("value popped is:"+min);
              min = 2*min -temp;
          }

        }
    }

    private  void peek(){
        if (s.isEmpty()){
            System.out.println("stack is empty");
        }
        else{
            Integer temp = s.peek();
            if(temp < min){
                System.out.println("value peek is: " + min);
            }
            else
                System.out.println("value peek is: " +temp);
        }
    }


    public static void main(String[] args) {
       StackOrderOne st = new StackOrderOne();
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
        st.getMin();

    }
}
