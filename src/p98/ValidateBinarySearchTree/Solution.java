package p98.ValidateBinarySearchTree;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        boolean checkLeft = (root.left == null) ? true : (root.left.val < root.val) ? true : false;
        checkLeft = (root.left == null) ? checkLeft : checkLeft && max(root.left) < root.val;
        boolean checkRight = (root.right == null) ? true : (root.right.val > root.val) ? true : false;
        checkRight = (root.right == null) ? checkRight : checkRight && min(root.right) > root.val;
        return checkLeft && checkRight && isValidBST(root.left) && isValidBST(root.right);
    }

    public int max(TreeNode root) {
        if (root.right == null) return root.val;
        return max(root.right);
    }

    public int min(TreeNode root) {
        if (root.left == null) return root.val;
        return max(root.left);
    }

}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}