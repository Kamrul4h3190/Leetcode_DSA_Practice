package Binary_Tree.leetcode_110;

public class App {
    public static void main(String[] args) {
        App app = new App();    TreeNode treeBuilder = new TreeNode();
//        int[] preorder = {1,2,3};int[] inorder = {1,2,3};
        int[] preorder = {3,9,20,15,7};int[] inorder = {9,3,15,20,7};
        TreeNode root = treeBuilder.buildTree(preorder,inorder);
        System.out.println("balanced tree : "+app.isBalanced(root));
    }
    public boolean isBalanced(TreeNode root) {
        int height = height(root);
        return height != -1;
    }
    private int height(TreeNode node){//postorder traverse
        if (node==null) return  0;

        int left = height(node.left);
        int right = height(node.right);

        if (Math.abs(left-right)>1) return -1;
        if (left==-1 || right==-1) return -1;

        return 1+Math.max(left,right);
    }
}