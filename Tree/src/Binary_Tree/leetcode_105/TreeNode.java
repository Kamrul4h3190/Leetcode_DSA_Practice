package Binary_Tree.leetcode_105;

import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    static ArrayList<Integer> inOrder(TreeNode root, ArrayList<Integer> sorted){//traversal function
        if (root==null) return null;

        inOrder(root.left,sorted);
        sorted.add(root.val);
        inOrder(root.right,sorted);

        return sorted;
    }

    static TreeNode findNode(TreeNode root, int val){
        if(root==null) return null;
        if(root.val == val) return root;
        if(val>root.val) return findNode(root.right,val);
        return findNode(root.left,val);
    }
}
