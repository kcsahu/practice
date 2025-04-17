package com.example.dsa.practice1.dp.robber;

/**
 * There are several consecutive houses along a street, each of which has some money inside.
 * There is also a robber, who wants to steal money from the homes, but he refuses to steal from adjacent homes.
 *
 * The capability of the robber is the maximum amount of money he steals from one house of all the houses he robbed.
 *
 * You are given an integer array nums representing how much money is stashed in each house. More formally,
 * the ith house from the left has nums[i] dollars.
 *
 * You are also given an integer k, representing the minimum number of houses the robber will steal from.
 * It is always possible to steal at least k houses.
 *
 * Return the minimum capability of the robber out of all the possible ways to steal at least k houses.
 */
public class HouseRobberIV {

    public static void main(String[] args) {
        int res = minCapability(new int[]{2, 3, 5, 9}, 2);
        System.out.println(res + " " + (res == 5));
//        Assert.isTrue(res == 5, "Wrong result");
        res = minCapability(new int[]{2, 7, 9, 3, 1}, 2);
        System.out.println(res + " " + (res == 2));
//        Assert.isTrue(res == 2, "Wrong result");
    }


    public static int minCapability(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num: nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int result = max;
        while(min <= max){
            int mid = min + ((max - min)>>1);
            if (canRob(nums, mid, k)) {
                result = mid;
                max = mid - 1;
            } else{
                min = mid + 1;
            }
        }
        return result;
    }

    private static boolean canRob(int[] nums, int maxRob, int k){
        int i=0;
        while(i < nums.length){
            if(nums[i] <= maxRob){
                i += 2;
                k--;
            } else{
                i++;
            }
            if(k == 0){
                return true;
            }
        }
        return false;
    }
}
