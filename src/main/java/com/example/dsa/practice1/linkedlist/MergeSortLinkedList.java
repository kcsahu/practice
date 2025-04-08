package com.example.dsa.practice1.linkedlist;

import com.example.dsa.practice1.common.LinkedListUtil;
import com.example.dsa.practice1.common.ListNode;

public class MergeSortLinkedList {

    public static void main(String[] args) {
        ListNode head = LinkedListUtil.createLinkedList(new int[]{1, 7, 6, 4, 2, 11, 3, 39, 23, 19, 45, 8, 7, 14, 24});
        LinkedListUtil.print(head, "Original: ");
        head = mergeSort(head);
        LinkedListUtil.print(head, "Sorted list: ");

    }

    private static ListNode mergeSort(ListNode head) {
        if (head != null && head.next != null) {
            ListNode mid = middle(head);
            ListNode right = mid.next;
            mid.next = null;

            ListNode leftSide = mergeSort(head);
            ListNode rightSide = mergeSort(right);
            return merge(leftSide, rightSide);
        }
        return head;
    }

    private static ListNode middle(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        while (left != null && right != null) {
            if (left.value <= right.value) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }

        if (left != null) {
            cur.next = left;
        } else {
            cur.next = right;
        }
        return newHead.next;
    }
}
