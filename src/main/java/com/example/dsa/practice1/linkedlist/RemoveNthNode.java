package com.example.dsa.practice1.linkedlist;

import com.example.dsa.practice1.common.LinkedListUtil;
import com.example.dsa.practice1.common.ListNode;

public class RemoveNthNode {

    public static void main(String[] args) {
        ListNode head = LinkedListUtil.createLinkedList(new int[]{1,2,3,4,5,6,7,8,9});
        LinkedListUtil.print(removeNthNode(head, 4));
        head = LinkedListUtil.createLinkedList(new int[]{1,2,3,4,5,6,7,8,9});
        LinkedListUtil.print(removeNthNode(head, 12));
        head = LinkedListUtil.createLinkedList(new int[]{1});
        head = removeNthNode(head, 1);
        LinkedListUtil.print(head);
    }
    /**
     * [1,2,3,4,5,6,7,8,9], 4 => [1,2,3,4,5,7,8,9]
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthNode(ListNode head, int n){
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode node1 = result;
        ListNode node2 = result;
        while(node1.next != null){
            node1 = node1.next;
            if(n > 0){
                n--;
            } else{
                node2 = node2.next;
            }
        }
        if(node1.next == null && n > 0){
            return result.next;
        }
        node2.next = node2.next.next;
        return result.next;
    }
}
