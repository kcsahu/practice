package com.example.dsa.practice1.linkedlist;

import com.example.dsa.practice1.common.LinkedListUtil;
import com.example.dsa.practice1.common.ListNode;

import java.util.List;

public class ReverseList {

    public static void main(String[] args) {
        ListNode head = LinkedListUtil.createLinkedList(new int[]{1, 2, 3, 4, 5, 6});
        ListNode reversed = reverse(head);
        LinkedListUtil.print(reversed, "Reverse: ");

        head = LinkedListUtil.createLinkedList(new int[]{3,5});
        int left = 1;
        int right = 2;
        head = reverseBetween(head, left, right);
        LinkedListUtil.print(head, "Reversed between " + left + " " + right + ": ");

        head = LinkedListUtil.createLinkedList(new int[]{1,2,3,4,5,6});
         left = 2;
         right = 4;
        head = reverseBetween(head, left, right);
        LinkedListUtil.print(head, "Reversed between " + left + " " + right + ": ");
    }

    private static ListNode reverse(ListNode head) {
        ListNode prevNode = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prevNode;
            prevNode = cur;
            cur = next;
        }
        return prevNode;
    }

    // Leet code verified.
    // Carve out the List for the left right position and reverse it.
    // Merge with the original list
    private static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode nextNode = null;
        ListNode prevNode = newHead;
        ListNode cur = prevNode;
        int n = 0;
        while (cur != null) {
            if (n == left - 1) {
                prevNode = cur;
            }
            if (n == right) {
                nextNode = cur;
                break;
            }
            n++;
            cur = cur.next;
        }
        ListNode tail = nextNode.next;
        nextNode.next = null;
        ListNode reversed = reverse2(prevNode.next, tail);
        prevNode.next = reversed;
        return newHead.next;
    }

    private static ListNode reverse2(ListNode head, ListNode nextNode) {
        if( head == null){
            return null;
        }
        ListNode prevNode = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prevNode;
            prevNode = cur;
            cur = next;
        }
        head.next = nextNode;
        return prevNode;
    }


}
