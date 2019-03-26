package Arslan.Ch03StackandQueues.Q3_04_Queue_via_Stacks;

import java.util.Queue;
import java.util.Stack;

public class Solution<T> {

        Stack<T> stackNewest, stackOldest;

        public Solution() {
                stackNewest=new Stack<T>();
                stackOldest=new Stack<T>();
        }

        public int size() {
            return stackOldest.size()+stackNewest.size();
        }

        public void add(T value) {
            if (!stackOldest.empty()){
                interchange_elements(stackOldest,stackNewest);
            }
            stackNewest.push(value);
        }

        public void interchange_elements(Stack<T> stack1,Stack<T>  stack2){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }

        public T peek() {
            if (stackOldest.empty()){
                interchange_elements(stackNewest,stackOldest);

            }
            return stackOldest.peek();
        }

        public T remove() {
            if (!stackOldest.empty()){
                interchange_elements(stackNewest,stackOldest);

            }
            return stackOldest.pop();
        }


    public void display() {
        System.out.println(stackNewest);
        System.out.println(stackOldest);
    }

    public static void main(String[] args) {
                    //Stack test=new Stack();
                    Solution test=new Solution();


                for (int i = 0; i < 10; i++) {
                    test.add(i);
                }
                test.display();
                System.out.println(test.peek());
                System.out.println(test.remove());
                System.out.println(test);



            }
    }




