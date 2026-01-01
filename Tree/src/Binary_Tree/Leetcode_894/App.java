package Binary_Tree.Leetcode_894;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        App app = new App();
        TreeNode treeBuilder = new TreeNode();
        List<TreeNode> completeBTs = app.allPossibleFBT(7);
    }
    Map<Integer,List<TreeNode>> treesMap = new HashMap<>();//key -n, value -all trees for n nodes
    public List<TreeNode> allPossibleFBT(int N) {
        if (treesMap.containsKey(N)) return treesMap.get(N);
        List<TreeNode> res = new ArrayList<>();
        if (N == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        N = N - 1;
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i);
            for (TreeNode nl : left) {
                for (TreeNode nr : right) {
                    TreeNode cur = new TreeNode(0);
                    cur.left = nl;
                    cur.right = nr;
                    res.add(cur);
                }
            }
        }
        treesMap.put(N,res);
        return res;//Operations are memoized, but still we need to find all the trees. O(2^N)
    }
}