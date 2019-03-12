package Arslan.Ch02LinkedLists.Q2_06_Palindrome;
import CtCILibrary.LinkedListNode;
public class Solution {
    
    public static char[] LL2ca(LinkedListNode ll){
        String s="";

        while(ll!=null){
            s=s+ll.data;
            ll=ll.next;
        }


        return s.toCharArray();
        
    }

    public static boolean isPalindrome(LinkedListNode head) {
        
        char[] c=LL2ca(head);
        int l= c.length;
        for (int i=0;i<l;i++) {
            if(c[i]!=c[l-1]) return false;
            l=l-1;

        }
        
        
        return true;
    }


    public static void main(String[] args) {
        int length = 9;
        LinkedListNode[] nodes = new LinkedListNode[length];
        for (int i = 0; i < length; i++) {
            nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
        }

        for (int i = 0; i < length; i++) {
            if (i < length - 1) {
                nodes[i].setNext(nodes[i + 1]);
            }
            if (i > 0) {
                nodes[i].setPrevious(nodes[i - 1]);
            }
        }
        // nodes[length - 2].data = 9; // Uncomment to ruin palindrome
        LinkedListNode lB1 = new LinkedListNode(5, null, null);
        LinkedListNode lB2 = new LinkedListNode(9, null, lB1);
        LinkedListNode lB3 = new LinkedListNode(5, null, lB2);


        LinkedListNode head = nodes[0];
        System.out.println(head.printForward());
        System.out.println(isPalindrome(head));

        System.out.println(lB1.printForward());
        System.out.println(isPalindrome(lB1));
    }
}
