package Arslan.Ch02LinkedLists.Q2_08_Loop_Detection;
import CtCILibrary.LinkedListNode;

import java.util.HashSet;

public class Solution {

    public static LinkedListNode FindBeginning(LinkedListNode head) {
        LinkedListNode slow=head;
        HashSet<LinkedListNode> hashSet=new HashSet<>();

        while (slow!=null){

            if(hashSet.contains(slow)){
                return slow;
            }

            hashSet.add(slow);

            slow=slow.next;

        }

    return null;
    }

    public static void main(String[] args) {
        int list_length = 100;
        int k = 10;

        // Create linked list
        LinkedListNode[] nodes = new LinkedListNode[list_length];
        for (int i = 0; i < list_length; i++) {
            nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
        }

        // Create loop;
        nodes[list_length - 1].next = nodes[list_length - k];

        LinkedListNode loop = FindBeginning(nodes[0]);
        if (loop == null) {
            System.out.println("No Cycle.");
        } else {
            System.out.println(loop.data);
        }
    }
}
