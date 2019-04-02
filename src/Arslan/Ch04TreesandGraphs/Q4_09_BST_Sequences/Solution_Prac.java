package Arslan.Ch04TreesandGraphs.Q4_09_BST_Sequences;

import Java.CtCILibrary.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution_Prac {

    public static void weave(LinkedList<Integer> first,
                             LinkedList<Integer> second,
                             LinkedList<Integer> prefix,
                             ArrayList<LinkedList<Integer>> results) {

        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = new LinkedList<>();
            result.addAll(prefix);
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;

        }

        prefix.addLast(first.removeFirst());
        weave(first, second, prefix, results);
        first.addFirst(prefix.removeLast());

        prefix.addLast(second.removeFirst());
        weave(first, second, prefix, results);
        second.addFirst(prefix.removeLast());


    }


    public static ArrayList<LinkedList<Integer>> allSequences(TreeNode node) {

        ArrayList<LinkedList<Integer>> results = new ArrayList<>();
        if (node == null) {
            results.add(new LinkedList<>());
            return results;
        }


        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.data);

        ArrayList<LinkedList<Integer>> leftseq = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightseq = allSequences(node.right);


        for (LinkedList<Integer> first : leftseq) {
            for (LinkedList<Integer> second : rightseq) {
                weave(first, second, prefix, results);
            }
        }
        return results;

    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(100);
        int[] array = {100, 50, 20, 75, 150, 120, 170};
        //int[] array = {2,8,3,9};
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

    @Test
    public void test_weave() {

        LinkedList<Integer> first = new LinkedList<Integer>();
        LinkedList<Integer> second = new LinkedList<Integer>();
        LinkedList<Integer> prefix = new LinkedList<Integer>();
        first.add(100);
        first.add(50);
        first.add(75);
        first.add(20);
        second.add(150);
        second.add(170);
        second.add(120);
        prefix.add(100);


        System.out.println();

        ArrayList<LinkedList<Integer>> results = new ArrayList<>();
        weave(first, second, prefix, results);

        System.out.println(results.size());

        for (LinkedList<Integer> result : results) {
            System.out.println(result);
        }
    }
}