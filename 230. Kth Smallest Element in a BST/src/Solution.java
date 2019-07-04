class Solution {
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        int t;
        if (root != null) {
            t = kthSmallest(root.left, k);
            if (t < Integer.MAX_VALUE) return t;
            if (++count == k) return root.val;
            t = kthSmallest(root.right, k);
            if (t < Integer.MAX_VALUE) return t;
        }
        return Integer.MAX_VALUE;
    }
}
