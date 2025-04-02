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
        ListNode node1 = head;
        while(n > 0){
            node1 = node1.next;
            n -= 1;
            if(node1 == null){
                return head;
            }
        }
        ListNode node2 = head;
        while(node1.next != null){
            node2 = node2.next;
            node1 = node1.next;
        }
        node2.next = node2.next.next;
        return head;
    }
}
