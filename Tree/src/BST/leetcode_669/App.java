package BST.leetcode_669;


public class App {
    public static void main(String[] args) {
        App app = new App();
        int[] preOder = {3,1,0,2,4},inOrder = {0,1,2,3,4};
        TreeNode root = TreeNode.buildTree(preOder,inOrder);

//        TreeNode root2 = app.trimBST(root,0,1);// structure changes ,so need new node after update
        TreeNode root2 = app.trimBST(root,3,4);
        TreeNode.inOrder(root2);
    }
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;

        if (root.val < low) return  trimBST(root.right, low, high);
        if (root.val > high) return trimBST(root.left, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}

