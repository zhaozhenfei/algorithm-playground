package leetcode.n199;

/**
 * Created by zhenfei7 on 2024/6/13.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

public class Solution {
    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        node1.left = node2;
//        node1.right = node3;
//        node2.right = node5;
//        node3.right = node4;
//        Solution solution = new Solution();
//        System.out.println(solution.rightSideView(node1));

        Solution solution = new Solution();
        System.out.println(solution.rightSideView(null));

    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int temp = queue.size();
            for (int i = 0; i < temp; i++) {
                if (i == temp - 1) {
                    result.add(queue.peek().val);
                }
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }

    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
