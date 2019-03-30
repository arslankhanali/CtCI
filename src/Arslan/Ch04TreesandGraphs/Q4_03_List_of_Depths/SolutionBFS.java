package Arslan.Ch04TreesandGraphs.Q4_03_List_of_Depths;

import Arslan.CtCILibrary.AssortedMethods;
import Arslan.CtCILibrary.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class SolutionBFS {
    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
        LinkedList<TreeNode> current= new LinkedList<>();
        
        if(root!=null){
            current.add(root);
        }
        //System.out.println("kokoko");
        while(!current.isEmpty()){
            result.add(current);
            
            LinkedList<TreeNode> parents=current;
            current= new LinkedList<>();

            for (TreeNode parent : parents) {
                if(parent.left!=null){
                    current.add(parent.left);
                }
                if(parent.right!=null){
                    current.add(parent.right);
                }
            }
            
        }

        return result;
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
        int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12,13,14,15,16};
        TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
        root.print();
        ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
        printResult(list);
    }

}
