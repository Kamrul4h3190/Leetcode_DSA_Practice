package BST.leetcode_783;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        App app = new App();
        int[] preorder = {27,34,58,50,44};
//        int[] preorder = {4,2,1,3,6};
        TreeNode root = TreeNode.bstFromPreorder(preorder);//build input tree
//        app.inorder(root);
//        System.out.println("inorder : "+TreeNode.inOrder(root,new ArrayList<>()));
        System.out.println("min distance : "+ app.minDiffInBST(root));
    }
    TreeNode prev = null;
    int minDistance = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        if (root==null) return 0;
        minDiffInBST(root.left);
        if (prev!=null) minDistance = Math.min(minDistance, root.val- prev.val);
        prev=root;
        minDiffInBST(root.right);
        return minDistance;
    }

}