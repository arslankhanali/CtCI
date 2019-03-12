package Arslan.Ch02LinkedLists.Q2_02_Return_Kth_To_Last;

import CtCILibrary.LinkedListNode;
import CtCILibrary.AssortedMethods;

public class QuestionD {
	
	public static LinkedListNode nthToLast(LinkedListNode head, int k) {
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;

		int l=0;
		while(p1 != null){
			 if (l<k){
				 l++;
			 }
			 else{
				 p2=p2.next;
			 }
            p1=p1.next;
		}
		return p2;
	}
	
	public static void main(String[] args) {
		int[] array = {0, 1, 2, 3};
		LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
		for (int i = 0; i <= array.length + 1; i++) {
			LinkedListNode node = nthToLast(head, i);
			String nodeValue = node == null ? "null" : "" + node.data;
			System.out.println(i + ": " + nodeValue);
		}
	}

}
