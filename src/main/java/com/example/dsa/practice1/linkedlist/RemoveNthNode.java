package com.example.dsa.practice1.linkedlist;

import com.example.dsa.practice1.common.LinkedListUtil;
import com.example.dsa.practice1.common.ListNode;

public class RemoveNthNode {

    public static void main(String[] args) {
        ListNode head = LinkedListUtil.createLinkedList(new int[]{1,2,3,4,5,6,7,8,9});
        LinkedListUtil.print(removeNthNode(head, 4));
        head = LinkedListUtil.createLinkedList(new int[]{1,2,3,4,5,6,7,8,9});
        LinkedListUtil.print(removeNthNode(head, 3));
    }
    /**
     * [1,2,3,4,5,6,7,8,9], 4 => [1,2,3,4,5,7,8,9]
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthNode(ListNode head, int n){
        ListNode fast = head;
        while(n > 0){
            fast = fast.next;
            n -= 1;
        }
        ListNode slow = head;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
