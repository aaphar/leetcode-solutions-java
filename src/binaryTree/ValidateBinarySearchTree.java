package binaryTree;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(2, new TreeNode(2), new TreeNode(2));
        System.out.println(isValidBST(node));
    }

    public static boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean valid(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (!(node.val > min && node.val < max)) {
            return false;
        }

        return valid(node.left, min, node.val) && valid(node.right, node.val, max);
    }
}
