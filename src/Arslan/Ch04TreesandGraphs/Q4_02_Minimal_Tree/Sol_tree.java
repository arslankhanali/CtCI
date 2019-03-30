package Arslan.Ch04TreesandGraphs.Q4_02_Minimal_Tree;

import Arslan.Ch03StackandQueues.Q3_06_Animal_Shelter.Solution;
import Arslan.CtCILibrary.BTreePrinter;

import java.util.ArrayList;
import java.util.Collections;

public class Sol_tree {
    int data;
    Sol_tree right, left, parent;
    int elements;


    public Sol_tree(int data) {
        this.data = data;
        elements = 1;
    }


    public void addtoleft(int d) {
        if (left == null) {
            left = new Sol_tree(d);
        } else {
            left.addlikeBST(d);
        }
    }

    public void addtoright(int d) {
        if (right == null) {
            right = new Sol_tree(d);
        } else {
            right.addlikeBST(d);
        }
    }

    public void addlikeBST(int d) {
        if (data == d) {
            System.out.println(d + " already in BST");
            return;
        } else if (d < data) {
            addtoleft(d);
        } else if (d > data) {
            addtoright(d);
        }
        elements++;
    }

    public boolean isBST() {
        if (this.right != null) {
            if (this.data > this.right.data) {
                return false;
            }
            this.right.isBST();
        }
        if (this.left != null) {
            if (this.data < this.left.data) {
                return false;
            }
            this.left.isBST();
        }
        return true;
    }

    public Sol_tree find(int d) {
        if (this.data == d) {
            System.out.println("FOUND ");
            return this;
        } else {
            if (this.data > d & this.left!=null) {
                this.left.find(d);
            }
            if (this.data < d & this.right!=null){
                this.right.find(d);
            }
        }

        return null;
    }

    @Override
    public String toString() {
        String s = "" + data;
        if (this.right != null) {
            s = s + "->" + right.toString() + "\n";
        }
        if (this.left != null) {
            s = s + "<-" + left.toString();
        }
        return s;
    }

    public void addtoleft(Sol_tree d) {
        if(this.left==null){
        this.left=d; }
        else{this.left.addtoleft(d);}
    }

    public void addtoright(Sol_tree d) {
        if(this.right==null){
        this.right=d;
        }
        else{
            this.right.addtoright(d);
        }
    }


    public static Sol_tree createminimalBST(ArrayList<Integer> arrayList){
        Collections.sort(arrayList);
        return createminimalBST(arrayList,0,arrayList.size()-1);
    }

    public static Sol_tree createminimalBST(ArrayList<Integer> arrayList,int start,int end){

        if(end<start){
            return null;
        }

        int mid= (end+start)/2;
        System.out.println("start:"+start);
        Sol_tree ans= new Sol_tree(arrayList.get(mid));
        ans.addtoleft(createminimalBST(arrayList,start,mid-1));
        ans.addtoright(createminimalBST(arrayList,mid+1,end));

        return ans;
        }

    public static void main(String[] args) {
//        Sol_tree bst= new Sol_tree(5);
//        bst.addlikeBST(1);
//        bst.addlikeBST(6);
//        bst.addlikeBST(4);
//        bst.addlikeBST(2);
//        bst.addlikeBST(3);
//        bst.addlikeBST(8);
//        bst.addlikeBST(7);
//        bst.addlikeBST(9);
//        bst.addlikeBST(3);
//
//        System.out.println("elements:" +bst.elements);
//        System.out.println(bst.toString());
//        Sol_tree founttest=bst.find(8);
//        System.out.println(founttest);


//        Sol_tree isbesttest = new Sol_tree(9);
//        isbesttest.addtoright(10);
//        isbesttest.addtoleft(50);
//        System.out.println(isbesttest.isBST());


        ArrayList<Integer> arrayList= new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            arrayList.add(i);
        }
        Sol_tree test=Sol_tree.createminimalBST(arrayList);
        System.out.println(test.toString());

    }
}
