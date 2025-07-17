package BST.leetcode_1008;

public class App {
    public static void main(String[] args) {
        App app = new App();
        int[] preorder = {8,5,1,7,10,12};

        TreeNode root = app.bstFromPreorder(preorder);
        TreeNode.inOrder(root);
    }

    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        int min=Integer.MIN_VALUE,max=Integer.MAX_VALUE;
        return bstBuilder(preorder,min,max);
    }
    private TreeNode bstBuilder(int[] preorder,int min,int max){
        if (index>=preorder.length) return null;
        if (preorder[index] < min || preorder[index]>max) return null;

        TreeNode root = new TreeNode(preorder[index]);

        index++;
        root.left = bstBuilder(preorder, min,root.val-1);
        //don't index++.if index nulls at left, Check curr index in right also.
        root.right = bstBuilder(preorder, root.val+1,max);

        return root;
    }
}
