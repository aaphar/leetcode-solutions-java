package binaryTree;

/**
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/description
 */
public class MinimumAbsoluteDifferenceInBST {

    // TODO
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(
                236, new TreeNode(104, null, new TreeNode(227)),
                new TreeNode(701, null, new TreeNode(911))
        );
        System.out.println(getMinimumDifference(treeNode));
    }

    static int prev = -1;
    static int min = Integer.MAX_VALUE;

    public static int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return min;
        }
        getMinimumDifference(root.left);
        if (prev != -1) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        getMinimumDifference(root.right);
        return min;
    }
}
