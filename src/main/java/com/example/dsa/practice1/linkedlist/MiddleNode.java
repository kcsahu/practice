package com.example.dsa.practice1.linkedlist;

import com.example.dsa.practice1.common.LinkedListUtil;
import com.example.dsa.practice1.common.ListNode;
// Fast and Slow pointers
public class MiddleNode {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ListNode head = LinkedListUtil.createLinkedList(nums);
        ListNode mid = findMiddle(head);
        System.out.println("Middle: " + mid);
        System.out.println("Middle: " + findMiddle1(head));
    }

    private static ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode findMiddle1(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
