package p230.KthSmallestElementInBST;

import java.util.Stack;

class Solution2 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        root = root.left;
        int counter = 0;
        while (root != null || !stack.isEmpty()) {
            if (root == null) {
                TreeNode top = stack.pop();
                counter++;
                if (counter == k) {
                    return top.val;
                }
                root = top.right;
            }
            if (root != null) {
                stack.push(root);
                root = root.left;
            }
        }
        return -1;
    }
}