package BST.leetcode_449;


public class App {
    public static void main(String[] args) {
        App app = new App();
        int[] preOder = {3,1,0,2,4},inOrder = {0,1,2,3,4};
        TreeNode root = TreeNode.buildTree(preOder,inOrder);

        String serialize = app.serialize(root);
        System.out.println("encoded : "+serialize);

        TreeNode root2 = app.deserialize(serialize);
        TreeNode.inOrder(root2);
    }

    StringBuilder serialize = new StringBuilder();
    public String serialize(TreeNode root) {
        if (root==null) {
            return serialize.append("N,").toString();
//            serialize.append("N,"); //same as above line
//            return "";
        }
        serialize.append(root.val+",");
        serialize(root.left);
        serialize(root.right);

        return serialize.toString();
    }


    int index = 0;
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        return buildTree(values);
    }
    private TreeNode buildTree(String[] values){
        if (values[index].equals("N")){
            index++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(values[index++]));

        root.left = buildTree(values);
        root.right = buildTree(values);

        return root;
    }

}
