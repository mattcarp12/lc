package p297.SerializeAndDeserializeBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return preOrderSerialize(root) + ";" + inOrderSerialize(root);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(";");
        return buildTree(split[0], split[1]);
    }
    
    private String preOrderSerialize(TreeNode root) {
        if (root == null) return "";
        return Integer.toString(root.val) + "," + preOrderSerialize(root.left) + "," + preOrderSerialize(root.right);
    }
    
    private String inOrderSerialize(TreeNode root) {
        if (root == null) return "";
        return inOrderSerialize(root.left) + "," + Integer.toString(root.val) + "," + inOrderSerialize(root.right);
    }
    
    private TreeNode buildTree(String preOrder, String inOrder) {
    	return null;
    }
    
    private String levelOrderSerialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            if (t == null) {
            	sb.append(" ,");
            } else {
            	q.offer(t.left);
                q.offer(t.right);
                sb.append(t.val + ",");
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	root.right.left = new TreeNode(4);
    	root.right.right = new TreeNode(5);
    	System.out.println(sol.levelOrderSerialize(root));
    	
    }
	

}

class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
 }
