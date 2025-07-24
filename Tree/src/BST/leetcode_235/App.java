package BST.leetcode_235;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        App app = new App();
        int[] preorder = {6,2,0,4,3,5,8,7,9};
        TreeNode root = TreeNode.bstFromPreorder(preorder);//build input tree
        TreeNode p = TreeNode.findNode(root,2);
        TreeNode q = TreeNode.findNode(root,8);
        System.out.println("LCA of BST : "+ app.lowestCommonAncestor(root,p,q).val);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if (p.val>root.val && q.val>root.val) return lowestCommonAncestor(root.right, p, q);
        if (p.val<root.val && q.val<root.val) return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}