package com.example.dsa.practice1.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        QuickSort obj = new QuickSort();
        int[] nums = {5,1,9,2,4,20,14};
        obj.sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.stream(nums).mapToObj(Integer::valueOf).toList());
    }

    private int findPivot(int[] nums, int start, int end){
        int pivotElement = nums[end];
        int pivot = start -1;
        for(int i = start; i<end; i++){
            if(nums[i] <= pivotElement){
                swap(nums, i, ++pivot);
            }
        }
        swap(nums, end, ++pivot);
        return pivot;
    }

    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    private void sort(int[] nums, int start, int end){
        while (start < end){
            int pivot = findPivot(nums, start, end);
            sort(nums, start, pivot - 1);
            start = pivot + 1;
        }
    }
}
