package p101.SymmetricTree;

import java.util.LinkedList;

public class Solution {
    public static boolean isSymmetric(TreeNode root) {
        LinkedList<TreeNode> currQueue, nextQueue;
        currQueue = new LinkedList<TreeNode>();
        nextQueue = new LinkedList<TreeNode>();
        currQueue.add(root);
        boolean allNull = false;
        TreeNode tempNode;
        while (!allNull(currQueue)) {
            while (currQueue.size() > 0) {
                tempNode = currQueue.poll();
                nextQueue.add(tempNode.left);
                nextQueue.add(tempNode.right);
            }
            currQueue.addAll(nextQueue);
            if (!isLevelSymmetric(nextQueue)) return false;
        }
        return true;
    }

    public static boolean isLevelSymmetric(LinkedList<TreeNode> queue) {
        int first, last;
        while (queue.size() > 0) {
            first = queue.pollFirst().val;
            last = queue.pollLast().val;
            if (first != last) return false;
        }
        return true;
    }

    public static boolean allNull(LinkedList queue) {
        LinkedList temp = (LinkedList) queue.clone();
        //temp = queue;
        boolean allNull = (temp.poll() == null);
        while (temp.size() > 0) {
            allNull = ((temp.poll() == null) && allNull);
        }
        return allNull;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.left.right = new TreeNode(3);
        t.right = new TreeNode(2);
        t.right.right = new TreeNode(3);
        boolean sol = isSymmetric(t);
        System.out.println(sol);
    }
}
