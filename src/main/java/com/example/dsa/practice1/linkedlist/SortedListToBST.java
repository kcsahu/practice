package com.example.dsa.practice1.linkedlist;

import com.example.dsa.practice1.common.BinaryTreeUtil;
import com.example.dsa.practice1.common.LinkedListUtil;
import com.example.dsa.practice1.common.ListNode;
import com.example.dsa.practice1.common.TreeNode;

public class SortedListToBST {

    public static void main(String[] args) {
        ListNode head = LinkedListUtil.createLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        TreeNode tNode = sortedListToBST(head);
        BinaryTreeUtil.print(tNode, "Binary Tree: ");
    }

    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return buildTree(head, null);
    }

    private static TreeNode buildTree(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode mid = findMiddle(head, tail);
        TreeNode tnode = new TreeNode(mid.value);
        tnode.left = buildTree(head, mid);
        tnode.right = buildTree(mid.next, tail);
        return tnode;
    }

    private static ListNode findMiddle(ListNode left, ListNode right) {
        ListNode slow = left;
        ListNode fast = left;
        while (fast != null && fast.next != right && fast.next.next != right) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
