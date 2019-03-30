package Arslan.Ch02LinkedLists.Q2_05_Sum_Lists;
import Java.CtCILibrary.LinkedListNode;

public class Solution {

    private static int LL2i(LinkedListNode l1) {
        String s="";
        while(l1!=null){
            s=s+l1.data;
            l1=l1.next;
        }
        Integer integer= Integer.parseInt(s);
        return integer;
    }

    private static LinkedListNode i2LL(Integer l1) {
        String s=Integer.toString(l1);
        String reverse = new StringBuilder(new String(s)).reverse().toString();
        char[] ss=s.toCharArray();

        LinkedListNode ans= new LinkedListNode();
        LinkedListNode current_ans=ans;

        for (Character c : ss) {
            current_ans= new LinkedListNode(Character.getNumericValue(c),null,current_ans);
        }
        return ans.next;
    }

    private static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {

        int i1=LL2i(l1);
        int i2=LL2i(l2);

        int i3=i1+i2;




        return i2LL(i3);
    }

    public static void main(String[] args) {

        LinkedListNode lA1 = new LinkedListNode(3, null, null);
        LinkedListNode lA2 = new LinkedListNode(1, null, lA1);

        LinkedListNode lB1 = new LinkedListNode(5, null, null);
        LinkedListNode lB2 = new LinkedListNode(9, null, lB1);
        LinkedListNode lB3 = new LinkedListNode(1, null, lB2);

        LinkedListNode list3 = addLists(lA1, lB1);
//        System.out.println(LL2i(lA1));
//        System.out.println(i2LL(123).printForward());

        System.out.println("  " + lA1.printForward());
        System.out.println("+ " + lB1.printForward());
        System.out.println("= " + list3.printForward());

    }
}
