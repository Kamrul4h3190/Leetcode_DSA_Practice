package BST.leetcode_450;

class Leetcode_450 {
    public static void main(String[] args) {
        Leetcode_450 testClass = new Leetcode_450();
        int[] preOrder = {4,2,1,3,7},inOrder = {1,2,3,4,7};

        TreeNode treeNode = new TreeNode();
        TreeNode root = TreeNode.buildTree(preOrder,inOrder);
//        TreeNode.inOrder(root);

        int key = 3;
        TreeNode subRoot = testClass.deleteNode(root,key);
        TreeNode.inOrder(subRoot);
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null) return root;

        if (key<root.val) root.left = deleteNode(root.left,key);
        else if(key>root.val) root.right = deleteNode(root.right,key);
        else {//key found
            if (root.left==null) return root.right;
            if (root.right==null) return root.left;

            root.val = leftMax(root.left);//has both child.rightMin is also good.
            root.left = deleteNode(root.left, root.val);
        }
        return root;
    }
    private int leftMax(TreeNode root){
        while (root.right!=null) root = root.right;
        return root.val;
    }
}

