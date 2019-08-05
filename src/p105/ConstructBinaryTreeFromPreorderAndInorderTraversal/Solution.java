package p105.ConstructBinaryTreeFromPreorderAndInorderTraversal;

class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    int[] preorder;
    int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        this.preorder = preorder;
        this.inorder = inorder;
        return buildTree(0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int pl, int pr, int il, int ir) {
        TreeNode node = new TreeNode(preorder[pl]);
        if (pl == pr) return node;
        int index = indexOf(inorder, preorder[pl]);
        if (index > il){
            node.left = buildTree(pl + 1, pl + index - il, il, index - 1);
        }
        if (pl + index - il + 1 < pr + 1) {
            node.right = buildTree(pl + index - il + 1, pr, index + 1, ir);
        }
        return node;
    }

    private int indexOf(int[] nums, int k) {
        int i;
        for(i = 0; i < nums.length; i++) {
            if (nums[i] == k) return i;
        }
        return -1;
    }
}