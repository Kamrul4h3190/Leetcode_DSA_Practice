package BST.leetcode_700;

import java.util.Arrays;

class Leetcode_700 {
    public static void main(String[] args) {
        Leetcode_700 testClass = new Leetcode_700();
        int[] nums = {4,2,7,1,3};
        int[] preOrder = {4,2,1,3,7},inOrder = {1,2,3,4,7};

        Arrays.sort(nums);//build tree
        TreeNode treeNode = new TreeNode();
        TreeNode root = TreeNode.buildTree(preOrder,inOrder);
//        TreeNode.inOrder(root);

        int val = 2;
        TreeNode subRoot = testClass.searchBST(root,val);
        TreeNode.inOrder(subRoot);
    }
    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null) return null;
        if (root.val==val) return root;

        if (val<root.val) return searchBST(root.left,val);
        return searchBST(root.right,val);
    }
}

