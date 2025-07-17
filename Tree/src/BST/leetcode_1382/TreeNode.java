package BST.leetcode_1382;

import java.util.ArrayList;
import java.util.List;

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
}
