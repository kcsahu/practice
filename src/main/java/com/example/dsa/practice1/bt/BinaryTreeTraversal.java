package com.example.dsa.practice1.bt;

import com.example.dsa.practice1.common.BinaryTreeUtil;
import com.example.dsa.practice1.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

public class BinaryTreeTraversal {

    public static void main(String[] args) {
        TreeNode root = BinaryTreeUtil.createBinaryTree(new int[]{1, 2, 3, 4, 5, 6, 7}, 0);
        BinaryTreeUtil.print(root, "Actual Binary Tree: ");
        List<Integer> preOrderTraversed = Stream.of(1, 2, 4, 5, 3, 6, 7).toList();
        List<Integer> result = preOrderTraversal(root);
        System.out.println("Pre-Order: " + result + " " + preOrderTraversed.equals(result));
        List<Integer> inOrderTraversed = Stream.of(4, 2, 5, 1, 6, 3, 7).toList();
        result = inOrderTraversal(root);
        System.out.println("In-Order: " + result + " " + inOrderTraversed.equals(result));
        List<Integer> postOrderTraversed = Stream.of(4, 5, 2, 6, 7, 3, 1).toList();
        result = postOrderTraversal(root);
        System.out.println("Post-Order: " + result + " " + postOrderTraversed.equals(result));

        List<Integer> levelOrderTraversed = Stream.of(1, 2, 3, 4, 5, 6, 7).toList();
        result = levelOrderTraversal(root);
        System.out.println("Level-Order: " + result + " " + levelOrderTraversed.equals(result));

    }

    /**
     * Root -> Left -> Right
     *
     * @param root
     * @return
     */
    private static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> traversed = new LinkedList<>();
        if (root == null) {
            return traversed;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (stack.size() > 0) {
            TreeNode node = stack.pop();
            traversed.add(node.value);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return traversed;
    }

    /**
     * Left -> Root -> Right
     *
     * @param root
     * @return
     */
    private static List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> traversed = new LinkedList<>();
        if (root == null) {
            return traversed;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                traversed.add(node.value);
                node = node.right;
            }
        }
        return traversed;
    }

    /**
     * Left -> right -> root
     *
     * @param root
     * @return
     */
    private static List<Integer> postOrderTraversal(TreeNode root) {
        LinkedList<Integer> traversed = new LinkedList<>();
        if (root == null) {
            return traversed;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (stack.size() > 0) {
            TreeNode node = stack.pop();
            traversed.offerFirst(node.value);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return traversed;
    }

    private static List<Integer> levelOrderTraversal(TreeNode root) {
        List<Integer> traversed = new LinkedList<>();
        if (root == null) {
            return traversed;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            traversed.add(node.value);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return traversed;
    }
}
