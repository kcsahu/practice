package com.example.dsa.practice1.array;

/**
 * ###  Tow pointers  ###
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 */
public class TrapRainWater {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trappedWater = trap(height);
        System.out.println("Trapped water: " + trappedWater);
        System.out.println(trappedWater == 6);
        height = new int[] {4,2,0,3,2,5};
        trappedWater = trap(height);
        System.out.println("Trapped water: " + trappedWater);
        System.out.println(trappedWater == 9);

    }
    // Two pointers
    public static int trap(int[] height) {
        int trappedWater = 0, leftMax = 0, rightMax = 0, left = 0, right = height.length - 1;
        while(left < right){
            if(height[left] < height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];
                } else {
                    trappedWater += leftMax - height[left];
                }
                left++;
            } else {
                if(height[right] >= rightMax){
                    rightMax = height[right];
                } else{
                    trappedWater += rightMax - height[right];
                }
                right--;
            }
        }
        return trappedWater;
    }
}
