package Arslan.Ch04TreesandGraphs.Q4_06_Successor;

import Java.CtCILibrary.TreeNode;

public class Solution {

    public static void traverse(TreeNode n){
        if(n!=null){
            traverse(n.left);
            System.out.print(n.data);
            traverse(n.right);
        }


    }
    public static TreeNode inorderSucc(TreeNode n) {
        if (n == null) return null;

       if(n.right!=null){
           return leftMostChild(n.right);
       }

       else{
           TreeNode q=n;
           TreeNode x=q.parent;

           while(x!=null && x.left!=q){
               q=x;
               x=x.parent;
           }
           return x;
       }
    }

    public static TreeNode leftMostChild(TreeNode n) {
        if (n == null) {
            return null;
        }
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        root.print();
        traverse(root);
        System.out.println();

        for (int i = 0; i < array.length; i++) {
            TreeNode node = root.find(array[i]);
            TreeNode next = inorderSucc(node);
            if (next != null) {
                System.out.println(node.data + "->" + next.data);
            } else {
                System.out.println(node.data + "->" + null);
            }
        }
    }

}
