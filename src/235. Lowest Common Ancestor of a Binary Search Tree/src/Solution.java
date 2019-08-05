class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int val0 = root.val;
        int val1 = p.val;
        int val2 = q.val;
        if (val0 == val1 || val0 == val2) return root;
        if ((val1 < val0 && val2 > val0) || (val2 < val0 && val1 > val0)) return root;
        if (val1 < val0) return lowestCommonAncestor(root.left, p, q);
        else return lowestCommonAncestor(root.right, p, q);
    }
}