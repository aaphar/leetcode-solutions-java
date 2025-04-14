package binaryTree;

/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/description/
 */
public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val > root.val) {
            return searchBST(root.right, val);
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        }
        return root;
    }
}
