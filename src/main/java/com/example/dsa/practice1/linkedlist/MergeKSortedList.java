package com.example.dsa.practice1.linkedlist;

import com.example.dsa.practice1.common.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import static com.example.dsa.practice1.common.LinkedListUtil.createLinkedList;
import static com.example.dsa.practice1.common.LinkedListUtil.print;

public class MergeKSortedList {

    public static void main(String[] args) {
        ListNode node1 = createLinkedList(new int[]{1, 5, 9, 12});
        ListNode node2 = createLinkedList(new int[]{2, 3, 10, 14, 17, 19});
        ListNode node3 = createLinkedList(new int[]{3, 4, 8, 13, 15});
        ListNode node4 = createLinkedList(new int[]{8, 14, 18, 29});
        ListNode merged = merge(Stream.of(node2, node3, node1, node4).toList());
        print(merged);
    }

    private static ListNode merge(List<ListNode> sortedList){
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparing(node -> node.value));
        for(ListNode node: sortedList){
            pq.offer(node);
        }
        ListNode newNode = new ListNode(-1);
        ListNode cur = newNode;
        while (pq.size() > 0){
            ListNode node = pq.poll();
            cur.next = node;
            cur = cur.next;
            if(node.next != null){
                pq.offer(node.next);
            }
        }
        return newNode.next;
    }
}
