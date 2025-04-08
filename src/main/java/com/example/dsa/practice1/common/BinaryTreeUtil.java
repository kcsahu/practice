package com.example.dsa.practice1.common;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeUtil {

    public static TreeNode createBinaryTree(int[] values, int index) {
        if (index < values.length) {
            TreeNode root = new TreeNode(values[index]);
            root.left = createBinaryTree(values, (index << 1) + 1);
            root.right = createBinaryTree(values, (index << 1) + 2);
            return root;
        }
        return null;
    }

    public static void print(TreeNode root, String msg) {
        if (root == null) {
            System.out.println();
        }
        List<Integer> traversedList = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            traversedList.add(node.value);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        System.out.println(msg + traversedList);
    }
}
