package com.example.dsa.practice1.common;

import java.util.Objects;

public class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListNode node)) return false;
        return value == node.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
