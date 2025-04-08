package com.example.dsa.practice1.linkedlist;

import com.example.dsa.practice1.common.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class LinkedListOperation {
    public static void main(String[] args) {
        // create a Linked list
        ListNode head = createLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        print(head, "Original: ");
        // Reverse a list
        head = reverse(head);
        print(head, "Reversed: ");
        // Remove nth node
        head = createLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        head = removeNthNode(head, 3);
        print(head, "Removed " + 3 + " node: ");
        // Rotate
        head = createLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7});
        int k = 2;
        head = rotate(head, k);
        print(head, "Rotated by postion- " + k + ": ");
        // Merge K sorted list
        ListNode node1 = createLinkedList(new int[]{1, 5, 7, 24});
        ListNode node2 = createLinkedList(new int[]{2, 5, 12});
        ListNode node3 = createLinkedList(new int[]{3, 6, 7, 11, 35});
        List<ListNode> sortedList = Stream.of(node1, node2, node3).toList();
        head = mergeKSortedList(sortedList);
        print(head, "Merged sorted List: ");

        // Remove duplicates
        head = createLinkedList(new int[]{1, 1, 1, 2, 3, 3, 3, 3, 3, 4, 5, 5, 5});
        print(head, "OriginalList: ");
        removeDuplicates(head);
        print(head, "After removing duplicates: ");
        // Find middle
        head = createLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9,});
        ListNode mid = findMiddle(head);
        print(head, "Original: ");
        System.out.println("Middle: " + mid.value);

    }


    private static ListNode createLinkedList(int[] nums) {
        ListNode temp = new ListNode(-1);
        ListNode cur = temp;
        for (int num : nums) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return temp.next;
    }

    private static void print(ListNode head, String message) {
        ListNode cur = head;
        List<Integer> result = new ArrayList<>();
        while (cur != null) {
            result.add(cur.value);
            cur = cur.next;
        }
        System.out.println(message + result);
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

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private static ListNode removeNthNode(ListNode head, int n) {
        ListNode node1 = head;
        while (n > 0) {
            node1 = node1.next;
            n--;
            if (node1 == null) {
                return head;
            }
        }
        ListNode node2 = head;
        while (node1.next != null) {
            node2 = node2.next;
            node1 = node1.next;
        }
        node2.next = node2.next.next;
        return head;
    }

    private static ListNode rotate(ListNode head, int k) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        k = k % len;
        if (k == 0) {
            return head;
        }
        ListNode node1 = head;
        while (k > 0) {
            node1 = node1.next;
            k--;
        }
        ListNode node2 = head;
        while (node1.next != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        ListNode newHead = node2.next;
        node2.next = null;
        node1.next = head;
        return newHead;
    }

    private static ListNode mergeKSortedList(List<ListNode> list) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparing(val -> val.value));
        for (ListNode node : list) {
            pq.add(node);
        }
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        while (pq.size() > 0) {
            ListNode node = pq.poll();
            cur.next = node;
            cur = cur.next;
            if (cur.next != null) {
                pq.offer(cur.next);
            }
        }
        return newHead.next;
    }

    private static ListNode removeDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.value == cur.next.value) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

}
