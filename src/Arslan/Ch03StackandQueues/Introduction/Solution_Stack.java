package Arslan.Ch03StackandQueues.Introduction;

import java.util.EmptyStackException;

public class Solution_Stack<T> {


    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private StackNode<T> top;

    public T pop() {
        if (top == null) throw new EmptyStackException();
        T popped=top.data;
        top=top.next;
        return popped;

    }

    public void push(T item) {
        StackNode<T> newnode= new StackNode<>(item);
        newnode.next=top;
        top=newnode;

    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        Solution_Stack<Integer> test= new Solution_Stack<Integer>();


        System.out.println(test.isEmpty());
        test.push(6);
        test.push(7);
        test.push(8);
        System.out.println(test.pop());
        System.out.println(test.pop());
        test.push(100);
        System.out.println(test.pop());
        System.out.println(test.pop());
        test.push(89);
        System.out.println(test.pop());
        test.push(6);
        test.push(7);
        System.out.println(test.isEmpty());
        test.push(8);
        System.out.println(test.peek());
    }

}
