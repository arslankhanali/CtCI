package Arslan.Ch04TreesandGraphs.Q4_04_Check_Balanced;

import Java.CtCILibrary.TreeNode;

public class Solution_2 {
    public static int checkHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int rightheight = checkHeight(root.right);
        if (rightheight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int leftheight = checkHeight(root.left);
        if (leftheight == Integer.MIN_VALUE) return Integer.MIN_VALUE;


        if (Math.abs(rightheight - leftheight) > 1) return Integer.MIN_VALUE;
        else {
            return (Math.max(rightheight,leftheight)+1); //ARSLAN
        }
    }

    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) == Integer.MIN_VALUE ? false : true; //ARSLAN
    }

    public static void main(String[] args) {
        // Create balanced tree
        int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);


        System.out.println("Is balanced? " + isBalanced(root));

        root.insertInOrder(4); // Add 4 to make it unbalanced

        System.out.println("Is balanced? " + isBalanced(root));
    }

}
