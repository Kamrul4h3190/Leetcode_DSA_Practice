package BST.leetcode_501;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        App app = new App();
        int[] preorder = {7,4,4,8,8,10};
        TreeNode root = TreeNode.bstFromPreorder(preorder);//build input tree
//        app.inorder(root);
//        System.out.println("inorder : "+TreeNode.inOrder(root,new ArrayList<>()));
        System.out.println("modes : "+ Arrays.toString(app.findMode(root)));
    }

    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] modes = new int[modesList.size()];
        int i=0;
        for (int mode:modesList) modes[i++] = mode;
        return modes;
    }
    ArrayList<Integer> modesList = new ArrayList<>();
    int currVal = 0;int currFreq=0;int maxFreq = 0;
    private void inorder(TreeNode root){
        if (root==null) return;
        inorder(root.left);

        if(root.val != currVal){//update freq counts
            currVal = root.val;
            currFreq = 1;
        }
        else currFreq++;

        if (currFreq>maxFreq){//compare maxFreq counts and insert/clear new nums
            modesList.clear();
            maxFreq = currFreq;
        }
        if (currFreq==maxFreq)  modesList.add(root.val);

        inorder(root.right);
    }

}