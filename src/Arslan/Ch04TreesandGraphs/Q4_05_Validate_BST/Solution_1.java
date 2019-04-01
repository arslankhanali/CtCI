package Arslan.Ch04TreesandGraphs.Q4_05_Validate_BST;

import Java.CtCILibrary.TreeNode;

import java.util.ArrayList;
/////SIMPLEST CASE: NOT CONSIDERING WHEN THERE CAN BE SAME VALUES IN TREE!

public class Solution_1 {


    public static ArrayList<Integer> arrayList;

    public static void getlist(TreeNode node) {
        if (node != null) {
            getlist(node.left);
            arrayList.add(node.data);
            getlist(node.right);
        }
    }

    public static boolean checkBST(TreeNode node) {
        arrayList = new ArrayList<>();
        getlist(node);
        System.out.println("arraylist: "+arrayList);
        int j = 0;

        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(j) > arrayList.get(i)) {
                return false;
            }
            j++;
        }
        return true;

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
 2   3
      \
      4
		*/
        int[] array2 = {1, 2, 3, 4};
        node = TreeNode.createMinimalBST(array2);
        node.left.data = 2;
        node.print();
        //last_printed = null;
        condition = checkBST(node);
        System.out.println("should be true: " + condition);

		/* Expect false: for right child: node.data <= last_printed.
   2
  / \
 /   \
 1   2
      \
      4
		 */
        int[] array3 = {1, 2, 3, 4};
        node = TreeNode.createMinimalBST(array3);
        node.right.data = 2;
        node.print();
        //last_printed = null;
        condition = checkBST(node);
        System.out.println("should be false: " + condition);


        int[] array4 = {1, 3, 5, 6, 10, 13, 15, 22};
        TreeNode node4 = TreeNode.createMinimalBST(array4);

        node4.right.right.left=new TreeNode(11); // "ruin" the BST property by changing one of the elements
        node4.print();

        condition = checkBST(node4);
        System.out.println("should be false: " + condition);

    }

}
