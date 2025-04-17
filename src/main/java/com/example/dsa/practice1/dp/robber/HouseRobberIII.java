package com.example.dsa.practice1.dp.robber;

import com.example.dsa.practice1.common.BinaryTreeUtil;
import com.example.dsa.practice1.common.TreeNode;

/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
 * Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses
 * in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken
 * into on the same night.
 * <p>
 * Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
 * <p>
 * Input: root = [3,2,3,null,3,null,1]
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 */
public class HouseRobberIII {

    public static void main(String[] args) {
        TreeNode root = BinaryTreeUtil.createBinaryTree(new Integer[]{3, 2, 3, null, 3, null, 1}, 0);
        int result = rob(root);
        System.out.println(result + " " + (result == 7));
        root = BinaryTreeUtil.createBinaryTree(new Integer[]{3, 4, 5, 1, 3, null, 1}, 0);
        result = rob(root);
        System.out.println(result + " " + (result == 9));
    }

    private static int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = postOrder(root);
        return Math.max(res[0], res[1]);
    }

    private static int[] postOrder(TreeNode node) {
        if (node == null) {
            return new int[2];
        }
        int[] left = postOrder(node.left);
        int[] right = postOrder(node.right);
        int[] res = new int[2];
        res[0] = left[1] + right[1] + node.value;
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
}
