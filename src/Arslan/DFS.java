package Arslan;

import Arslan.CtCILibrary.AssortedMethods;
import Arslan.CtCILibrary.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class DFS {


    public static void printDFS(TreeNode root) {
        if(root==null){return;}

        printDFS(root.right);
        printDFS(root.left);
        System.out.println(root.data);
    }

    public static void printResult(ArrayList<LinkedList<TreeNode>> result){
        int depth = 0;
        for(LinkedList<TreeNode> entry : result) {
            Iterator<TreeNode> i = entry.listIterator();
            System.out.print("Link list at depth " + depth + ":");
            while(i.hasNext()){
                System.out.print(" " + ((TreeNode)i.next()).data);
            }
            System.out.println();
            depth++;
        }
    }


    public static void main(String[] args) {
        int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
        root.print();
        printDFS(root);

    }

}
