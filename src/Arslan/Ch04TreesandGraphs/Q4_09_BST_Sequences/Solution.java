package Arslan.Ch04TreesandGraphs.Q4_09_BST_Sequences;

import Java.CtCILibrary.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public static void weaveLists(LinkedList<Integer> first,
                                  LinkedList<Integer> second,
                                  ArrayList<LinkedList<Integer>> results,
                                  LinkedList<Integer> prefix) {

        if(first.size()==0 || second.size()==0){
            LinkedList<Integer> result= new LinkedList<>();
            result.addAll(prefix);
            result.addAll(first);
            result.addAll(second);
            
            results.add(result);
            return;
        }
        
        
        prefix.addLast(first.removeFirst());
        weaveLists(first,second,results,prefix);
        first.addFirst(prefix.removeLast());


        prefix.addLast(second.removeFirst());
        weaveLists(first,second,results,prefix);
        second.addFirst(prefix.removeLast());
    }

    public static ArrayList<LinkedList<Integer>> allSequences(TreeNode node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
        if(node==null){
            result.add(new LinkedList<>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<Integer>();
        prefix.add(node.data);

        ArrayList<LinkedList<Integer>> leftSeq=allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSeq=allSequences(node.right);

        System.out.println("p "+prefix);
        System.out.println("l "+leftSeq);
        System.out.println("r "+rightSeq);

        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);

                System.out.println("R "+result);
                System.out.println("----------");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(100);
        int[] array = {100, 50, 20, 75, 150, 120, 170};

        for (int a : array) {
            node.insertInOrder(a);
        }
        node.print();

        ArrayList<LinkedList<Integer>> allSeq = allSequences(node);
        for (LinkedList<Integer> list : allSeq) {
            System.out.println(list);
        }
        System.out.println(allSeq.size());
    }

}
