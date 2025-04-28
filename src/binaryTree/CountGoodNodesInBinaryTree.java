package binaryTree;

/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/description
 */
public class CountGoodNodesInBinaryTree {

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, root.val);
    }

    public int dfs(TreeNode root, int val) {
        int count = 0;
        if (root.val >= val) {
            count++;
        }
        int left = 0;
        int right = 0;

        int newMxm = Math.max(val, root.val);

        if (root.left != null) {
            left = dfs(root.left, newMxm);
        }
        if (root.right != null) {
            right = dfs(root.right, newMxm);
        }
        return count + left + right;
    }
}
