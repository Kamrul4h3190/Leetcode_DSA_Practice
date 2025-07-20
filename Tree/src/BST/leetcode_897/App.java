package BST.leetcode_897;

import com.sun.source.tree.Tree;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        App app = new App();
        int[] preorder = {3,2,1,4};
//        int[] preorder = {4,2,1,3,6};
        TreeNode root = TreeNode.bstFromPreorder(preorder);//build input tree

        TreeNode newRoot = app.increasingBST(root);
        System.out.println("right skewed tree : "+ TreeNode.inOrder(newRoot,new ArrayList<>()));
    }
    TreeNode dummyRoot,current;
    public TreeNode increasingBST(TreeNode root) {
        dummyRoot = new TreeNode();
        current = dummyRoot;
        inorder(root);
        return dummyRoot.right;
    }
    private void inorder(TreeNode root){
        if (root==null) return;

        inorder(root.left);
        root.left = null;
        current.right = root;
        current = root;
        inorder(root.right);
    }
}