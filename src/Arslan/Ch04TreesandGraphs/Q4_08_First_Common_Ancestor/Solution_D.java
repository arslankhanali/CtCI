package Arslan.Ch04TreesandGraphs.Q4_08_First_Common_Ancestor;

import Java.CtCILibrary.TreeNode;

public class Solution_D {


    public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!covers(root, p) || !covers(root, q)) { // Error check - one node is not in tree
            return null;
        }
        return ancestorHelper(root, p, q);
    }

    public static TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q) {

        boolean Ponleft = covers(root.left, p);
        boolean Qonleft = covers(root.left, q);
        boolean SameSide;

        if (Ponleft == Qonleft) SameSide = true;
        else SameSide = false;


        if (!SameSide) return root;
        else {

            return ancestorHelper(Ponleft ? root.left : root.right, p, q);
        }


    }

    public static boolean covers(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root == p) return true;
        return covers(root.left, p) || covers(root.right, p);
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        TreeNode n3 = root.find(1);
        TreeNode n7 = root.find(4);
        root.print();
        TreeNode ancestor = commonAncestor(root, n3, n7);
        System.out.println(ancestor.data);
    }

}
