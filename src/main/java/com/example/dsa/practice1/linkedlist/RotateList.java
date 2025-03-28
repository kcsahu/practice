package com.example.dsa.practice1.linkedlist;

import com.example.dsa.practice1.common.LinkedListUtil;
import com.example.dsa.practice1.common.ListNode;

public class RotateList {

    public static void main(String[] args) {
        ListNode head = LinkedListUtil.createLinkedList(new int[]{1,2,3,4,5,6,7,8,9});
        ListNode newHead = rotate(head, 2);
        LinkedListUtil.print(newHead);
    }

    /**
     * [1,2,3,4,5,6,7,8,9], 2 => [8,9,1,2,3,4,5,6,7]
     * @param head
     * @param k
     * @return
     */
    private static ListNode rotate(ListNode head, int k){
        int size = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            size += 1;
        }
        k = k % size;
        if(k == 0){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(k > 0){
            fast = fast.next;
            k -= 1;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next  = head;
        return newHead;
    }
}
