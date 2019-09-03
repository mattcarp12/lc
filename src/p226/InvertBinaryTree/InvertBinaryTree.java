package p226.InvertBinaryTree;

public class InvertBinaryTree {

    /**
     * Use recursion to invert a binary tree.
     * If the tree is null, then return it. This is the base case.
     * Otherwise, recursively call invertTree on the two child nodes,
     * then swap those two nodes.
     *
     * @param root
     * @return inverted root
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
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
