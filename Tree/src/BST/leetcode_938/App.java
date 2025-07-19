package BST.leetcode_938;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        App app = new App();
        int[] preorder = {10,5,3,7,15,18};    int low = 7,high = 15;
        TreeNode root = TreeNode.bstFromPreorder(preorder);//build input tree
//        app.inorder(root);
//        System.out.println("inorder : "+TreeNode.inOrder(root,new ArrayList<>()));
        System.out.println("range sum BST : "+ app.rangeSumBST(root,low,high));
    }
    public int rangeSumBST(TreeNode root, int low, int high) {//beats 100%
        if(root==null) return 0;

        if(root.val<low) return rangeSumBST(root.right,low,high);
        if(root.val>high) return rangeSumBST(root.left,low,high);

        return root.val+rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high);
    }

//    int rangeSum=0;
//    public int rangeSumBST(TreeNode root, int low, int high) {//beats 46%
//        if (root==null) return 0;
////        if (root.val < low || root.val>high) return 0;
////
//        rangeSumBST(root.left,low,high);
//        if (root.val>=low && root.val<=high) rangeSum+= root.val;
//        rangeSumBST(root.right,low,high);
//
//        return rangeSum;
//    }

}