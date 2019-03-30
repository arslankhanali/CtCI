package Arslan.Ch04TreesandGraphs.Q4_03_List_of_Depths;

import Arslan.CtCILibrary.AssortedMethods;
import Arslan.CtCILibrary.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class SolutionDFS {
    public static void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> arrayList, int level) {

    if(root==null)return;
    LinkedList<TreeNode> LL=null;

    if(arrayList.size()==level){ // TRICKY!
        LL=new LinkedList<>();
        arrayList.add(LL);
    }
    else {
        arrayList.get(level).add(root);
    }

    createLevelLinkedList(root.left,arrayList,level+1);
    createLevelLinkedList(root.right,arrayList,level+1);

    }

    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> arrayList = new ArrayList<LinkedList<TreeNode>>();
        createLevelLinkedList(root, arrayList, 0);
        return arrayList;
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
        int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12,13,14,15,16,17,18};
        TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
        root.print();
        ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
        printResult(list);
    }

}
