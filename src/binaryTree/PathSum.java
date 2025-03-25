package binaryTree;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (targetSum - root.val == 0 && root.left == null && root.right == null) {
            return true;
        }
        boolean left = false;
        boolean right = false;
        if (root.left != null) {
            left = hasPathSum(root.left, targetSum - root.val);
        }
        if (root.right != null) {
            right = hasPathSum(root.right, targetSum - root.val);
        }
        return left || right;
    }
}
