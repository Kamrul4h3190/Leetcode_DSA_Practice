package BST.leetcode_1305;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        App app = new App();
        int[] preorder1 = {2,1,4};int[] preorder2 = {1,0,3};
        TreeNode root1 = TreeNode.bstFromPreorder(preorder1);//build input tree
        TreeNode.index=0;
        TreeNode root2 = TreeNode.bstFromPreorder(preorder2);//build input tree

        System.out.println("merged BST : "+ app.getAllElements(root1,root2));
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = inOrder(root1,new ArrayList<>());
        List<Integer> list2 = inOrder(root2,new ArrayList<>());
        if(root1==null) return list2;   if(root2==null) return list1;
        return mergeList(list1,list2);
    }
    private List<Integer> mergeList(List<Integer> list1,List<Integer> list2){
        List<Integer> merged = new ArrayList<>();   int i=0,j=0;
        while (i< list1.size() && j< list2.size()){
            if (list1.get(i)<=list2.get(j)) merged.add(list1.get(i++));
            else merged.add(list2.get(j++));
        }

        while (i<list1.size()) merged.add(list1.get(i++));
        while (j<list2.size()) merged.add(list2.get(j++));
        return merged;
    }
    private static ArrayList<Integer> inOrder(TreeNode root, ArrayList<Integer> sorted){//traversal function
        if (root==null) return null;

        inOrder(root.left,sorted);
        sorted.add(root.val);
        inOrder(root.right,sorted);

        return sorted;
    }

}