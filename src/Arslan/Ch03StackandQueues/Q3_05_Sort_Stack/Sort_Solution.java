package Arslan.Ch03StackandQueues.Q3_05_Sort_Stack;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Stack;

public class Sort_Solution {

    public static void sort(Stack<Integer> stack){
        Stack<Integer> r= new Stack();
        System.out.println(stack);


        while(!stack.empty()){
            int tmp=  stack.pop();

            while(!r.empty() && r.peek()>tmp){
                stack.add(r.pop());
            }
            System.out.println(r);
            r.add(tmp);

        }


        stack.addAll(r);


    }

    public static void main(String [] args) {
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < 10; i++) {
            int r = CtCILibrary.AssortedMethods.randomIntInRange(0,  1000);
            s.push(r);
        }

        sort(s);

        System.out.println("ANSWER-> "+s);

    }
}
