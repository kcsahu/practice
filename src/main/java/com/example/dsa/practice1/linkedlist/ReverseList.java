package com.example.dsa.practice1.linkedlist;

import com.example.dsa.practice1.common.LinkedListUtil;
import com.example.dsa.practice1.common.ListNode;

public class ReverseList {

    public static void main(String[] args) {
        ListNode head = LinkedListUtil.createLinkedList(new int[]{1, 2, 3, 4, 5, 6});
        ListNode reversed = reverse(head);
        LinkedListUtil.print(reversed, "Reverse: ");
    }

    private static ListNode reverse(ListNode head){
        ListNode prevNode = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = prevNode;
            prevNode = cur;
            cur = next;
        }
        return prevNode;
    }
}
