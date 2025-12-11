package com.example.dsa.practice1.sorting;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        HeapSort obj = new HeapSort();
        int[] arr1 = new int[]{4, 1, 7, 2, 24, 23, 8, 3};
        obj.buildMaxHeap(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr = {45, 39, 6, 14, 5, 29, 3, 1, 56, 28, 48, 25, 22, 44, 29};
        obj.heapSort(arr);
        System.out.println(Arrays.toString(arr));
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
        for (int i = mid; i >= 0; i--) {
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
