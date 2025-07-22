package BST.leetcode_99;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        App app = new App();
        int[] preorder = {4,9,8,6,2};//swapped
//        int[] preorder = {4,2,8,6,9};//bst,not swapped
        TreeNode root = TreeNode.bstFromPreorder(preorder);//build input tree

        app.recoverTree(root);
        System.out.println("recovered BST : "+TreeNode.inOrder(root,new ArrayList<>()));
    }
    TreeNode first,last,prev;
    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);//trivial case valid, comparison purpose

        inorder(root);
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
    }
    private void inorder(TreeNode root){
        if (root==null) return;

        inorder(root.left);
        if (root.val< prev.val){
            if (first==null) first = prev;

            if (last==null) last = root;
            else if (root.val< last.val) last = root;
        }

        prev=root;
        inorder(root.right);
    }
}