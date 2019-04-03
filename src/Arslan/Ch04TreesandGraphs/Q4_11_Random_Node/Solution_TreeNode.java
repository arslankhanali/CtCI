package Arslan.Ch04TreesandGraphs.Q4_11_Random_Node;

import Arslan.CtCILibrary.BTreePrinter;

import java.util.Random;

public class Solution_TreeNode {

    public int data, size;
    Solution_TreeNode right, left;

    public Solution_TreeNode() {
        this.data = Integer.MIN_VALUE;
        this.right = null;
        this.left = null;
    }

    public void insertInOrder(int i) {
        if (i == data) {
            System.out.println("Already present");
        } else if (data == Integer.MIN_VALUE) {
            data = i;

        } else if (i > data) {
            if (this.right == null) {
                Solution_TreeNode r = new Solution_TreeNode();
                r.insertInOrder(i);
                this.right = r;
                //size++;
            } else {
                this.right.insertInOrder(i);
            }
        } else if (i <= data) {
            if (this.left == null) {
                Solution_TreeNode l = new Solution_TreeNode();
                l.insertInOrder(i);
                this.left = l;
                //size++;
            } else {
                this.left.insertInOrder(i);
            }
        }

    size++; //Also adds when System.out.println("Already present") ;(
    }

    public Solution_TreeNode find(int i) {
        if (i == data) {
            return this;
        } else if (i > data) {
            if (this.right == null) {
                return null;
            } else {
                this.right.find(i);
            }
        } else if (i <= data) {
            if (this.left == null) {
                return null;
            } else {
                this.left.find(i);
            }
        }
        return null;
    }

    public void delete(int i) {


    }

    public Solution_TreeNode getRandomNode() {
        Random random = new Random();
        int leftSize = this.left == null ? 0 : this.left.size;
        int index = random.nextInt(size); //size not included but zero included

        if (index < leftSize) {
            return this.left.getRandomNode();
        } else if (index == leftSize) {
            return this;
        } else {
            return right.getRandomNode();
        }
    }

    public void printtraverse(){
        if(this==null) {
            return;
        }
        if(this.left!=null)this.left.printtraverse();
        System.out.print(this.data);
        if(this.right!=null)this.right.printtraverse();
    }

}
