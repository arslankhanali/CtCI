package Arslan.Ch02LinkedLists.Q2_01_Remove_Dups;

import CtCILibrary.LinkedListNode;

import java.util.HashSet;

public class QuestionA {
	public static void deleteDups(LinkedListNode n) {

		HashSet hashSet= new HashSet();
		LinkedListNode prev=null;

		while (n != null ){
			if(hashSet.contains(n.data)){
				prev.next=n.next;
			}
			else {
				hashSet.add(n.data);
				prev=n;


			}
			n=n.next;
			//if (n!= null) System.out.println( n.printForward());


		}

	}
	
	public static void main(String[] args) {	
		LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 8; i++) {
			second = new LinkedListNode(i % 2, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		System.out.println(head.printForward());
		deleteDups(head);
		System.out.println(head.printForward());
	}
}
