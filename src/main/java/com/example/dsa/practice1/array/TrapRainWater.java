package com.example.dsa.practice1.array;

/**
 * Tow pointers
 */
public class TrapRainWater {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trappedWater = trap(height);
        System.out.println("Trapped water: " + trappedWater);
        System.out.println(trappedWater == 6);
    }
    // Two pointers
    public static int trap(int[] height) {
        int len = height.length;
        int left=0, right=len-1, leftMax=0, rightMax=0, trappedWater = 0;
        while(left < right){
            if(height[left] < height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];
                } else{
                    trappedWater += leftMax - height[left];
                }
                left++;
            } else{
                if(height[right] >= rightMax){
                    rightMax = height[right];
                }else{
                    trappedWater +=  rightMax - height[right];
                }
                right--;
            }
        }
        return trappedWater;
    }
}
