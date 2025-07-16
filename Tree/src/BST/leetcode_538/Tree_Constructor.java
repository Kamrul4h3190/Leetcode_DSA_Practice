package BST.leetcode_538;

public class Tree_Constructor {
    public static void main(String[] args) {
        Tree_Constructor app = new Tree_Constructor();
        int[] preOder = {1,0,2},inOrder = {0,1,2};
        TreeNode root = TreeNode.buildTree(preOder,inOrder);

        app.convertBST(root);
        TreeNode.inOrder(root);
    }
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null) return null;
        convertBST(root.right);
        root.val = sum+=root.val;//sum = sum+ root.val; root.val = sum
        convertBST(root.left);
        return root;
    }
}

