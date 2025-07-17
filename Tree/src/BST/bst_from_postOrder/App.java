package BST.bst_from_postOrder;

public class App {
    public static void main(String[] args) {
        App app = new App();
        int[] postOrder = {1,7,5,12,10,8};
        app.index = postOrder.length-1;
        TreeNode root = app.bstFromPostorder(postOrder);
        TreeNode.inOrder(root);
    }

    int index;
    public TreeNode bstFromPostorder(int[] preorder) {
        int min=Integer.MIN_VALUE,max=Integer.MAX_VALUE;
        return bstBuilder(preorder,min,max);
    }
    private TreeNode bstBuilder(int[] preorder, int min, int max){
        if (index<0) return null;
        if (preorder[index] < min || preorder[index]>max) return null;

        TreeNode root = new TreeNode(preorder[index]);

        index--;
        root.right = bstBuilder(preorder, root.val+1,max);
        //don't index--.if index nulls at right, Check curr index in left also.
        root.left = bstBuilder(preorder, min,root.val-1);

        return root;
    }
}
