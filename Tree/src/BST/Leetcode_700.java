package BST;

import java.util.Arrays;
import java.util.HashMap;

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
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;   if (length==1) return new TreeNode(preorder[0]);

        HashMap<Integer,Integer> infixMap = new HashMap<>(); for (int i = 0; i <length ; i++) infixMap.put(inorder[i],i);

        return buildTree(preorder,0,length-1,inorder,0,length-1,infixMap);
    }
    private static TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                                      int[] inorder, int inLeft, int inRight,
                                      HashMap<Integer, Integer> infixMap) {
        if (preLeft>preRight || inLeft>inRight ) return null;
        TreeNode root = new TreeNode(preorder[preLeft]);
        if (inRight-inLeft== 0 && preRight-preLeft==0) return root;

        int infixRootIndex = infixMap.get(root.val);
        int leftSubTreeLen = infixRootIndex - inLeft;
        root.left = buildTree(preorder,preLeft+1,preLeft+leftSubTreeLen,
                inorder,inLeft,infixRootIndex-1,infixMap);
        root.right = buildTree(preorder,preLeft+leftSubTreeLen+1,preRight,
                inorder,infixRootIndex+1,inRight,infixMap);

        return root;
    }
    static void inOrder(TreeNode root){//traversal function
        if (root==null) return;
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
}