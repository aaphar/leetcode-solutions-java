package binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/leaf-similar-trees/
 */
public class LeafSimilarTrees {
    List<Integer> root1List = new ArrayList<>();
    List<Integer> root2List = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        leefs(root1, root1List);
        leefs(root2, root2List);

        return equalLists(root1List, root2List);
    }

    public void leefs(TreeNode root, List<Integer> list) {
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }

        if (root.left != null) {
            leefs(root.left, list);
        }
        if (root.right != null) {
            leefs(root.right, list);
        }
    }

    public boolean equalLists(List<Integer> list1, List<Integer> list2) {
        int size1 = list1.size();
        int size2 = list2.size();
        if (size1 != size2) {
            return false;
        }
        for (int i = 0; i < size1; i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }
}
