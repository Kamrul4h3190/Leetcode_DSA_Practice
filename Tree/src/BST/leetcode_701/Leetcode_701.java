package BST.leetcode_701;

import java.util.Arrays;

class Leetcode_701 {
    public static void main(String[] args) {
        Leetcode_701 testClass = new Leetcode_701();
        int[] preOrder = {4,2,1,3,7},inOrder = {1,2,3,4,7};

        TreeNode treeNode = new TreeNode();
        TreeNode root = TreeNode.buildTree(preOrder,inOrder);
//        TreeNode.inOrder(root);

        int val = 5;
        TreeNode subRoot = testClass.insertIntoBST(root,val);
        TreeNode.inOrder(subRoot);
    }
    //time: omega(height),theta(logN),O(N)
    //space : O(N)
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root==null) return new TreeNode(val);

        if (val<root.val) root.left = insertIntoBST(root.left,val);
        else root.right = insertIntoBST(root.right,val);

        return root;
    }
}

