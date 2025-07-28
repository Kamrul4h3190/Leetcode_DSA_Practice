package Binary_Tree.leetcode_572;

public class App {
    public static void main(String[] args) {
        App app = new App();    TreeNode treeBuilder = new TreeNode();
        int[] preorder1 = {3,4,1,2,5};int[] inorder1 = {1,4,2,3,5};
        int[] preorder2 = {4,1,2};int[] inorder2 = {1,4,2};
        TreeNode root = treeBuilder.buildTree(preorder1,inorder1);   treeBuilder.preOrderRootIndex=0;
        TreeNode subRoot = treeBuilder.buildTree(preorder2,inorder2);
        System.out.println("subTree : "+app.isSubtree(root,subRoot));
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null) return false;
        if(root.val==subRoot.val && sameTree(root,subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean sameTree(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null) return true;
        if(root==null ^ subRoot==null) return false;
        if (root.val != subRoot.val) return false;
        return sameTree(root.left, subRoot.left) && sameTree(root.right, subRoot.right);
    }
}