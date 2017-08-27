package n665.non.decreasing.array;

import java.util.Arrays;

/**
 * <p>665. Non-decreasing Array</p>
 * <p>Difficulty: Easy</p>
 * <p>Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.</p>

 <p>We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).</p>

 <p>Example 1:<br>
 Input: [4,2,3]<br>
 Output: True<br>
 Explanation: You could modify the first 4 to 1 to get a non-decreasing array.</p>
 <p>Example 2:<br>
 Input: [4,2,1]<br>
 Output: False<br>
 Explanation: You can't get a non-decreasing array by modify at most one element.</p>
 <p>Note: The n belongs to [1, 10,000].</p>
 */
public class Solution {

    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i=0; i<nums.length-1; i++){
            if (nums[i]>nums[i+1]) {
                if (canModify(nums, i) || canModify(nums, i + 1)) {
                    count++;
                } else {
                    return false;
                }
            }
        }
        return count<=1;
    }

    private boolean canModify(int[] nums, int i){
        return i-1<0 || i+1>=nums.length || nums[i-1]<=nums[i+1];
    }

    public static void main(String[] args) {
        Object[] test = {
                new int[]{4,2,3}, true,
                new int[]{4,2,1}, false,
                new int[] {4,5,6,9,1,2,3}, false,
                new int[] {1,2,3,4,5,9,6}, true,
                new int[] {9,1,2,3,4,5,6}, true,
                new int[] {3,4,2,3}, false,
                new int[] {2,3,3,2,4}, true
        };
        Solution solution = new Solution();
        for (int i=0; i<test.length; i+=2){
            System.out.println(Arrays.toString((int[]) test[i])+" -> "+solution.checkPossibility((int[]) test[i])+" ("+test[i+1]+")");
        }

    }
}
