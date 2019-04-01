package Arslan.Ch04TreesandGraphs.Q4_05_Validate_BST;

import Java.CtCILibrary.AssortedMethods;
import Java.CtCILibrary.TreeNode;

public class Solution3 {
    public static boolean checkBST(TreeNode n, Integer min, Integer max) {
        if (n == null) {
            return true;
        }
        if ((min != null && n.data <= min) || (max != null && n.data > max)) {
            return false;
        }
        if (!checkBST(n.left, min, n.data) || !checkBST(n.right, n.data, max)) {
            return false;
        }
        return true;
    }

    public static boolean checkBST(TreeNode n) {
        return checkBST(n, null, null);
    }

    public static void main(String[] args) {
        /* Simple test -- create one */
        int[] array = {1, 3, 5, 6, 10, 13, 15, 22};
        TreeNode node = TreeNode.createMinimalBST(array);

        node.left.right.data = 77; // "ruin" the BST property by changing one of the elements

        node.print();
        boolean isBst = checkBST(node);

        System.out.println("Should be false : "+isBst);



    }
}
