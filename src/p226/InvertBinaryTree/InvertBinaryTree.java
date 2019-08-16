package p226.InvertBinaryTree;

public class InvertBinaryTree {
    TreeNode root;
    InvertBinaryTree() {}
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(1);
        InvertBinaryTree.invertTree(root);
    }
}
