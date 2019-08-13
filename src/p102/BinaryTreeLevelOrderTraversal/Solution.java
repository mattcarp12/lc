package p102.BinaryTreeLevelOrderTraversal;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList();
        List<List<Integer>> levelOrder = new ArrayList<>();
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(root);
        while (!q1.isEmpty()) {
            while (!q1.isEmpty()) {
                q2.offer(q1.poll());
            }
            List<Integer> level = new ArrayList<>();
            while (!q2.isEmpty()) {
                TreeNode t = q2.poll();
                if (t != null) {
                    level.add(t.val);
                    q1.offer(t.left);
                    q1.offer(t.right);
                }
            }
            if (!level.isEmpty()) levelOrder.add(level);
        }
        return levelOrder;
    }
}