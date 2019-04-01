package Arslan.Ch04TreesandGraphs.Q4_05_Validate_BST;

import Java.CtCILibrary.TreeNode;

import java.util.ArrayList;

public class Solution_2 {

    public static Integer last_value; //So we dont have to use int wrapper b/c int!=null

    public static boolean getlist(TreeNode node) {
        if (node != null) {

            if(getlist(node.left)==false)return false; // TRICK Propagate inside boolean to outside

            if (last_value != null && node.data < last_value) {
                return false;
            }
            else last_value = node.data;

            if(getlist(node.right)==false)return false; //TRICK


        }

        return true;
    }

    public static boolean checkBST(TreeNode node) {
        last_value = null;
        return getlist(node);

    }


    public static void main(String[] args) {
        int[] array = {Integer.MIN_VALUE, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE};
        TreeNode node = TreeNode.createMinimalBST(array);
        System.out.println(checkBST(node));

        test();
    }

    public static void test() {
        TreeNode node;
        boolean condition;
        System.out.println("test cases for equals condition.");

		/* Expect true: for left child: node.data <= last_printed.
   2
  / \
 /   \
 5   3
      \
      4
		*/
        int[] array2 = {1, 2, 3, 4};
        node = TreeNode.createMinimalBST(array2);
        node.left.data = 5;
        node.print();
        //last_printed = null;
        condition = checkBST(node);
        System.out.println("should be false: " + condition);

		/* Expect false: for right child: node.data <= last_printed.
   2
  / \
 /   \
 1   3
      \
      4
		 */
        int[] array3 = {1, 2, 3, 4};
        node = TreeNode.createMinimalBST(array3);
        node.right.data = 3;
        node.print();
        //last_printed = null;
        condition = checkBST(node);
        System.out.println(checkBST(node));

        System.out.println("should be true: " + condition);
    }

}
