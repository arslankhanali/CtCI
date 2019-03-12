package Arslan.Ch02LinkedLists.Q2_04_Partition;

import CtCILibrary.LinkedListNode;

public class Solution {

    public static LinkedListNode partition(LinkedListNode node, int x) {
        LinkedListNode left,right,current_left,current_right = new LinkedListNode();
        left=null;
        right=null;
        current_left=null;
        current_right=null;
       

        while (node != null) {
            if (node.data < x) {
                if (left == null) {
                    left=new LinkedListNode(node.data,null,null);
                    current_left=left;
                    System.out.println("1stleft="+left.printForward());

               }
               else {
                   current_left=new LinkedListNode(node.data,null,current_left);
                    System.out.println("left="+left.printForward());
               }
           }
           else if(node.data>=x){
                if (right == null) {
                    right=new LinkedListNode(node.data,null,null);
                    current_right=right;
                    System.out.println("1stright="+right.printForward());

                }
                else {
                    current_right=new LinkedListNode(node.data,null,current_right);
                    System.out.println("right="+right.printForward());
                }

           }
           node=node.next;
       }

       current_left.next=right;
        return left;

   }


    public static void main(String[] args) {
        /* Create linked list */
        int[] vals = {33,9,2,3,10,10389,838,874578,5};
        LinkedListNode head = new LinkedListNode(vals[0], null, null);
        LinkedListNode current = head;
        for (int i = 1; i < vals.length; i++) {
            current = new LinkedListNode(vals[i], null, current);
        }
        System.out.println(head.printForward());

        /* Partition */
        LinkedListNode h = partition(head, 10);

        /* Print Result */
        System.out.println(h.printForward());
    }

}
