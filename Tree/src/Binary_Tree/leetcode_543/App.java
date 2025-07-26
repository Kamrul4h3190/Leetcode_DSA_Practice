package Binary_Tree.leetcode_543;

public class App {
    public static void main(String[] args) {
        App app = new App();    TreeNode treeBuilder = new TreeNode();
//        int[] preorder = {1,2,3};int[] inorder = {1,2,3};
        int[] preorder = {3,9,20,15,7};int[] inorder = {9,3,15,20,7};
        TreeNode root = treeBuilder.buildTree(preorder,inorder);
        System.out.println("diameter of tree : "+app.diameterOfBinaryTree(root));
    }
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }
    private int height(TreeNode node){//postorder traverse
        if (node==null) return  0;

        int left = height(node.left);
        int right = height(node.right);

        diameter = Math.max(diameter,left+right);//update the diameter
        return 1+Math.max(left,right);//return curr node depth
    }
}