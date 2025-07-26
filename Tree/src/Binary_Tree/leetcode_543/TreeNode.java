package Binary_Tree.leetcode_543;

import java.util.ArrayList;
import java.util.HashMap;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;   if (length==1) return new TreeNode(preorder[0]);
        HashMap<Integer,Integer> inorderMap = new HashMap<>(); for (int i = 0; i <length ; i++) inorderMap.put(inorder[i],i);
        return build(0,length-1, preorder,inorderMap);
    }
    int preOrderRootIndex = 0;//not static, new for every call
    private TreeNode build(int start, int end, int[] preorder, HashMap<Integer,Integer> inorderMap){
        if(start>end) return null;

        TreeNode root = new TreeNode(preorder[preOrderRootIndex]);
        if (start==end) {preOrderRootIndex++;return root;}
        int inorderPartition = inorderMap.get(root.val);
        preOrderRootIndex++;//increment for next calls;
        root.left = build(start, inorderPartition-1, preorder, inorderMap);
        root.right = build(inorderPartition+1, end, preorder, inorderMap);// do not preOrderRootIndex++ after left call.value of preOrderRootIndex may fail at left, check right also.

        return root;
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
