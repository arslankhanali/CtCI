package Arslan.Ch02LinkedLists.Q2_07_Intersection;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;


public class Solution {

    public static LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {

        LinkedListNode current_list2=list2;
        while (list1 != null) {
            //System.out.println("list1 " + list1.data + "  " + list1);

            while (current_list2 != null) {
               // System.out.println("list2 " + current_list2.data + "  " + current_list2);

                if (list1.equals(current_list2)) {
                    System.out.println("MATCH! "+ list1.hashCode()+" & "+current_list2.hashCode()+" data "+list1.data);

                    return list1;
                }

                current_list2 = current_list2.next;

            }
            current_list2=list2;
            list1 = list1.next;

        }

        return null;
    }

    public static void main(String[] args) {
        /* Create linked list */
        int[] vals = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        LinkedListNode list1 = AssortedMethods.createLinkedListFromArray(vals);

        int[] vals2 = {12, 14, 15};
        LinkedListNode list2 = AssortedMethods.createLinkedListFromArray(vals2);

        list2.next.next = list1.next.next.next.next;

        System.out.println(list1.printForward());
        System.out.println(list2.printForward());


        LinkedListNode intersection = findIntersection(list1, list2);

        System.out.println(intersection.printForward());
    }
}
