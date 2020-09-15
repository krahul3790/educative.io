package com.company.patternscodingquestions.slidingwindow;

/**
 * Problem Statement:-
 *
 * Given a list of positive integers and a +ve number k,
 * find the maximum sum of any contiguous subarray of size 'k'.
 *
 * Approach:-
 * Sliding Window Pattern.
 *
 * 1. Maintain two indexes to keep track of the window.
 * 2. Maintain windowSum to keep track of the windowSum.
 * 3. Maintain maxSum to keep track of the maximum sum.
 *
 * [4,1,8,2,7,5,3,9]
 * low=0,high=0,windowSum=4,maxSum=0
 * low=0,high=1,windowSum=5,maxSum=0
 * low=0,high=2,windowSum=13,maxSum=13,(high-low = k)
 * low=1,high=3,windowSum=
 *
 * Test Cases
 * [], k = 3 -> 0
 * [4,1,8,2,7,5,3,9] , k = 3 -> [8,2,7] = 17
 */
public class MaxSumSubArray {

    // TODO: Modularize code.
    // Problems:
    // 1. Long function length
    // 2. Lot of state variables, try to include more functions.
    public static int maxSumSubArray(int [] list, int k) {
        if (list == null || list.length <= 1) {
            return -1;
        }

        int low = 0;
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int high=0; high < list.length; ++high) {
            curSum += list[high];
            if (high-low >= k-1) {
                maxSum = Math.max(maxSum, curSum);
                curSum-=list[low];
                low++;
            }
        }
        return maxSum;
    }
}
