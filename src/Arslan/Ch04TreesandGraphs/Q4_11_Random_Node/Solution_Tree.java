package Arslan.Ch04TreesandGraphs.Q4_11_Random_Node;

import java.util.Random;

public class Solution_Tree {
    Solution_TreeNode root = new Solution_TreeNode();


    public void insertInOrder(int value) {
        root.insertInOrder(value);

    }

    public int size() {
        return root == null ? 0 : root.size;
    }


    public void printtraverse() {
        root.printtraverse();
    }

    public Solution_TreeNode getRandomNode() {
        if (root == null) return null;
        return root.getRandomNode();
    }


}

