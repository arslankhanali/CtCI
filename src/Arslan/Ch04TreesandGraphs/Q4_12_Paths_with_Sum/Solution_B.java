package Arslan.Ch04TreesandGraphs.Q4_12_Paths_with_Sum;

import Java.CtCILibrary.TreeNode;

public class Solution_B {

    public static int countPathsWithSum(TreeNode root, int targetSum) {

        if (root == null) return 0;

        int pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0);

        int l = countPathsWithSum(root.left, targetSum);
        int r = countPathsWithSum(root.right, targetSum);

        return pathsFromRoot + l + r;
    }

    public static int countPathsWithSumFromNode(TreeNode node, int targetSum, int currentSum) {
        if (node == null) {
            return 0;
        }
        currentSum = currentSum + node.data;
        int count = 0;

        if (currentSum == targetSum) {
            count++;
        }

        int l = countPathsWithSumFromNode(node.left, targetSum, currentSum);
        int r = countPathsWithSumFromNode(node.right, targetSum, currentSum);



        return count + l + r;


    }

    public static void main(String[] args) {
		/*
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(-8);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(6);
		System.out.println(countPathsWithSum(root, 0));*/

		/*TreeNode root = new TreeNode(-7);
		root.left = new TreeNode(-7);
		root.left.right = new TreeNode(1);
		root.left.right.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(20);
		root.right.right.left = new TreeNode(0);
		root.right.right.left.left = new TreeNode(-3);
		root.right.right.left.left.right = new TreeNode(2);
		root.right.right.left.left.right.left = new TreeNode(1);
		System.out.println(countPathsWithSum(root, -14));*/

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.left.right = new TreeNode(0);
        root.right.right = new TreeNode(0);
        int pathsFromRoot = countPathsWithSumFromNode(root, 0, 0);
        System.out.println(pathsFromRoot);
        System.out.println(countPathsWithSum(root, 0));
        System.out.println(countPathsWithSum(root, 4));
    }
}
