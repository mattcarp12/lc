package p113.PathSumII;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<List<Integer>> paths = new ArrayList<List<Integer>>();
    private List<Integer> currPath = new ArrayList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        pathSumHelper(root, sum);
        return paths;
    }

    public void pathSumHelper(TreeNode root, int sum) {
        if (root == null) return;
        int leftOver = sum - root.val;
        currPath.add(root.val);
        if (root.left == null && root.right == null && leftOver == 0)
            paths.add(new ArrayList<>(currPath));
        pathSumHelper(root.left, leftOver);
        pathSumHelper(root.right, leftOver);
        if(!currPath.isEmpty()) currPath.remove(currPath.size() - 1);
    }
}



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
 