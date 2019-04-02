package Arslan.Ch04TreesandGraphs.Q4_11_Random_Node;

import java.util.Random;

public class Solution_Tree {
    Solution_TreeNode root=new Solution_TreeNode();
    int size;

    public void insertInOrder(int value) {
        root.insertInOrder(value);
        size++;
    }

    public int size() {
        return root == null ? 0 : size;
    }


    public void printtraverse(){
        root.printtraverse();
    }

    public TreeNode getRandomNode() {

        return null;
    }

}

