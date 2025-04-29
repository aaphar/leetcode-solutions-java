package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree
 */
public class AverageOfLevelsInBinaryTree {
    // bfs
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int count = 0;
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode tempNode = queue.poll();
                sum += tempNode.val;
                count++;
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }

                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }

            list.add(sum / count);
        }
        return list;
    }
}
