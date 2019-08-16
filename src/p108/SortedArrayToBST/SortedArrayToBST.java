package p108.SortedArrayToBST;

public class SortedArrayToBST {

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private static TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left == right) return new TreeNode(nums[left]);
        if (right - left == 1) {
            TreeNode root = new TreeNode(nums[right]);
            root.left = new TreeNode(nums[left]);
            return root;
        }
        int med = (left + right + 1) / 2;
        TreeNode root = new TreeNode(nums[med]);
        root.left = sortedArrayToBST(nums, left, med - 1);
        root.right = sortedArrayToBST(nums, med + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6};
        SortedArrayToBST.sortedArrayToBST(nums);

    }

}
