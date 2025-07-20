package BST.leetcode_653;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        App app = new App();
        int[] preorder = {5,3,2,4,6,7};
//        int[] preorder = {4,2,1,3,6};
        TreeNode root = TreeNode.bstFromPreorder(preorder);//build input tree

        int k = 9;
        System.out.println("two sum found : "+ app.findTarget(root,k));
    }
    public boolean findTarget(TreeNode root, int k) {
        boolean found = false;
        ArrayList<Integer> inorder = inOrder(root,new ArrayList<>());
        int i = 0,j= inorder.size()-1;
        while (i<j){
            if (inorder.get(i)+inorder.get(j)==k){found=true;break;}
            if (inorder.get(i)+inorder.get(j)<k)i++;
            else j--;
        }
        return found;
    }
    static ArrayList<Integer> inOrder(TreeNode root, ArrayList<Integer> sorted){//traversal function
        if (root==null) return null;

        inOrder(root.left,sorted);
        sorted.add(root.val);
        inOrder(root.right,sorted);

        return sorted;
    }
}