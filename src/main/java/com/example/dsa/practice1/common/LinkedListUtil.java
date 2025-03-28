package com.example.dsa.practice1.common;

import java.util.ArrayList;
import java.util.List;

public class LinkedListUtil {
    public static ListNode createLinkedList(int[] arr){
        ListNode result = new ListNode(-1);
        ListNode current = result;
        for(int num : arr){
            current.next = new ListNode(num);
            current = current.next;
        }
        return result.next;
    }

    public static List<Integer> print(ListNode head){
        List<Integer> result = new ArrayList<>();
        ListNode current = head;
        while(current != null){
            result.add(current.value);
            current = current.next;
        }
        System.out.println(result);
        return result;
    }
    public static void print(ListNode head, String message) {
        ListNode listNode = head;
        List<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.value);
            listNode = listNode.next;
        }
        System.out.println(message + ": " + list);
    }
}
