package Arslan.Ch03StackandQueues.Introduction;

import java.util.NoSuchElementException;

public class Solution_Queue<T> {

    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private QueueNode<T> last;
    private QueueNode<T> first;

    public T remove() {
        if (first == null) throw new NoSuchElementException();
        T popped=first.data;
        first=first.next;

        return popped;

    }

    public void add(T item) {
        QueueNode<T> newnode= new QueueNode<>(item);
        if(first==null){
            first=new QueueNode<>(item);
            last=first;
        }
        else {
            last.next=newnode;

        last=last.next;
    }
        
    }

    public T peek() {
        if (first == null) throw new NoSuchElementException();
        return last.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public static void main(String[] args) {
        Solution_Queue<Integer> test= new Solution_Queue<Integer>();


        System.out.println(test.isEmpty());
        test.add(6);
        test.add(7);
        test.add(8);
        System.out.println(test.remove());
        System.out.println(test.remove());
        test.add(100);
        System.out.println(test.remove());
        System.out.println(test.remove());
        test.add(89);
        System.out.println(test.remove());
        test.add(6);
        test.add(7);
        System.out.println(test.isEmpty());
        test.add(8);
        System.out.println(test.peek());
    }
}
