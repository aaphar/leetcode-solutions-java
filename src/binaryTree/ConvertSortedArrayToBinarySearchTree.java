package binaryTree;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description
 */
public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree solution = new ConvertSortedArrayToBinarySearchTree();
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = solution.sortedArrayToBST(nums);
        // You can add code here to print or verify the structure of the BST
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = buildTree(nums, left, mid - 1);
        node.right = buildTree(nums, mid + 1, right);

        return node;
    }
}
