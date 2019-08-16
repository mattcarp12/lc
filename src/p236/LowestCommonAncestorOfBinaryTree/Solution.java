package p236.LowestCommonAncestorOfBinaryTree;

import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1 = new ArrayList<TreeNode>();
        path1.add(root);
        ArrayList<TreeNode> path2 = new ArrayList<TreeNode>();
        path2.add(root);
        findPath(root, p, path1);
        findPath(root, q, path2);
        int i = 0;
        for(i = 0; i < path1.size() && i < path2.size(); i++){
            if (path1.get(i) != path2.get(i)) break;
        }
        return path1.get(i - 1);
    }

    public boolean findPath(TreeNode root, TreeNode p, ArrayList path) {
        if(root == null) return false;
        if (root.val == p.val) return true;
        path.add(root.left);
        if (findPath(root.left, p, path)) return true;
        path.remove(root.left);
        path.add(root.right);
        if (findPath(root.right, p, path)) return true;
        path.remove(root.right);
        return false;
    }


}