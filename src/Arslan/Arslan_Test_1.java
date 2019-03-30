package Arslan;

import java.util.LinkedList;

public class Arslan_Test_1 {

    public static void main(String[] args) {
        LinkedList<Integer> LL= new LinkedList<>();

        LL.add(0);
        LL.add(1);
        LL.add(2);
        LL.add(3);
        LL.add(4);
        LL.add(5);

        System.out.println(LL.size());
        System.out.println(LL.getFirst());
        System.out.println(LL.getLast());
        LL.addLast(6);
        System.out.println(LL.removeFirst());
        System.out.println(LL.removeLast());

        System.out.println(LL.toString());



    }
}
