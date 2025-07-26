package Binary_Tree.leetcode_105;

import java.util.ArrayList;
import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        App app = new App();
//        int[] preorder = {1,2};int[] inorder = {2,1};
        int[] preorder = {3,9,20,15,7};int[] inorder = {9,3,15,20,7};
        TreeNode root = app.buildTree(preorder,inorder);
        System.out.println("inorder : "+TreeNode.inOrder(root,new ArrayList<>()));
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
}