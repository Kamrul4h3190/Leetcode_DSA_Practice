package Binary_Tree.leetcode_889;

import java.util.ArrayList;
import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        App app = new App();
        int[] preorder = {2,1};int[] postorder = {1,2};
//        int[] preorder = {1,2,4,5,3,6,7};int[] postorder = {4,5,2,6,7,3,1};
//        int[] preorder = {3,9,20,15,7};int[] postorder = {9,15,7,20,3};
        TreeNode root = app.constructFromPrePost(preorder,postorder);
        System.out.println("inorder : "+ TreeNode.inOrder(root,new ArrayList<>()));
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int length = preorder.length;   if (length==1) return new TreeNode(preorder[0]);
        HashMap<Integer,Integer> postorderMap = new HashMap<>(); for (int i = 0; i <length ; i++) postorderMap.put(postorder[i],i);
        return build(0,length-1, postorder,preorder,postorderMap);
    }

    int preOrderRootIndex = 1;//not static, new for every call.next root is after curr index ,so from 1.
    private TreeNode build(int start, int end, int[] postorder,int[] preorder, HashMap<Integer,Integer> postorderMap){
        if (start>end) return null;

        TreeNode root = new TreeNode(postorder[end]);
        if(start==end) {preOrderRootIndex++;return root;}
        int partitionInPost = postorderMap.get(preorder[preOrderRootIndex]);
        preOrderRootIndex++;
        root.left = build(start,partitionInPost, postorder,preorder, postorderMap);
        root.right = build(partitionInPost+1,end-1,postorder,preorder,postorderMap);

        return root;
    }
}