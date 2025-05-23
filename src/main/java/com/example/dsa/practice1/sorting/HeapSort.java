package com.example.dsa.practice1.sorting;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        HeapSort obj = new HeapSort();
        int[] arr = {45, 39, 6, 14, 5, 29, 3, 1, 56, 28, 48, 25, 22, 44, 29};
        obj.heapSort(arr);
        System.out.println(Arrays.stream(arr).mapToObj(Integer::valueOf).toList());
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private void maxHeapify(int[] arr, int index, int len) {
        int left = (index << 1) + 1;
        int right = (index << 1) + 2;
        int largest = index;
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != index) {
            swap(arr, largest, index);
            maxHeapify(arr, largest, len);
        }
    }

    private void buildMaxHeap(int[] arr) {
        int len = arr.length;
        int mid = len >>> 1;
        for (int i = mid; i < len; i++) {
            maxHeapify(arr, i, len);
        }
    }

    private void heapSort(int[] arr) {
        buildMaxHeap(arr);
        int len = arr.length;
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            maxHeapify(arr, 0, i);
        }
    }

}
