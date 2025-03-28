package com.example.dsa.practice1.linkedlist;

import com.example.dsa.practice1.common.ListNode;
// Fast slow pointers
public class DetectCircle {

    private static boolean hasCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
