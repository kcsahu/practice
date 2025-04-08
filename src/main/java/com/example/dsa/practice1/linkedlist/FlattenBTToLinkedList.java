package com.example.dsa.practice1.linkedlist;

import com.example.dsa.practice1.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class FlattenBTToLinkedList {

    public static void main(String[] args) {

    }

    public static void flatten(TreeNode root) {
        if (root != null) {
            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            TreeNode temp = null;
            while (stack.size() > 0) {
                TreeNode node = stack.pop();
                if(temp == null){
                    temp = node;
                }else{
                    temp.right = node;
                    temp.left = null;
                    temp = node;
                }
                if(node.right != null){
                    stack.push(node.right);
                }
                if(node.left != null){
                    stack.push(node.left);
                }
            }
        }
    }
}
