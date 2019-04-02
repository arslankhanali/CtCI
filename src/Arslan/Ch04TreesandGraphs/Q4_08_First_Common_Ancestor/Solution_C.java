package Arslan.Ch04TreesandGraphs.Q4_08_First_Common_Ancestor;

import Java.CtCILibrary.TreeNode;

public class Solution_C {
    public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        if (!covers(root, p) || !covers(root, q)) return null;

        TreeNode s = getSibling(p);

        while (s != null) {
            if (covers(s, q)) {
                System.out.println("HIT");
                return s.parent;
            }

            s = getSibling(s.parent);

            System.out.println(s.data);
        }

        return null;
    }

    public static boolean covers(TreeNode root, TreeNode p) {

        while (p != null) {
            if (root == p) return true;
            p = p.parent;
        }
        return false;
    }

    public static TreeNode getSibling(TreeNode node) {

        TreeNode p = node.parent;

        if (p.left == node) return p.right;
        else return p.left;

    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        TreeNode n3 = root.find(1);
        TreeNode n7 = root.find(7);
        root.print();
        System.out.println(getSibling(root.find(9)).data);
        System.out.println(covers(root.find(8), root.find(7)));
        TreeNode ancestor = commonAncestor(root, n3, n7);
        System.out.println(ancestor.data);
    }
}
