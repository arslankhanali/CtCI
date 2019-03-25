package Arslan.Ch03StackandQueues.Q3_02_Stack_Min;

import java.security.DrbgParameters;
import java.util.EmptyStackException;
import java.util.Stack;


public class Solution extends Stack{

    class nodewithmin{
        int value;
        int min;

        public nodewithmin(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    Stack<nodewithmin> s;
    nodewithmin n;
    int minval=0;

    public Solution() { }




    public void push(int value){
        if(s==null) {
            minval = Math.min(value,Integer.MAX_VALUE );
            s=new Stack<>();
        }
        else{
            minval = Math.min(value,s.peek().min);
        }
        n= new nodewithmin(value,minval);
        s.add(n);
    }

    public Integer pop() {
        return s.pop().value;
    }

    public Integer min() {
        if(s.isEmpty()){
            return Integer.MAX_VALUE;
        }
        else return s.peek().min;
    }

}