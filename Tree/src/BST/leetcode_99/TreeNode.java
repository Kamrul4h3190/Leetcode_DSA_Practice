package BST.leetcode_99;

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
    static int index = 0;
    public static TreeNode bstFromPreorder(int[] preorder) {
        int min=Integer.MIN_VALUE,max=Integer.MAX_VALUE;
        return bstBuilder(preorder,min,max);
    }
    private static TreeNode bstBuilder(int[] preorder, int min, int max){
        if (index>=preorder.length) return null;
        if (preorder[index] < min || preorder[index]>max) return null;

        TreeNode root = new TreeNode(preorder[index]);

        index++;
        root.left = bstBuilder(preorder, min,root.val-1);
        //don't index++.if index nulls at left, Check curr index in right also.
        root.right = bstBuilder(preorder, root.val+1,max);

        return root;
    }

    static ArrayList<Integer> inOrder(TreeNode root, ArrayList<Integer> sorted){//traversal function
        if (root==null) return null;

        inOrder(root.left,sorted);
        sorted.add(root.val);
        inOrder(root.right,sorted);

        return sorted;
    }

}
