package n300.longest.increasing.subsequence;

import java.util.Arrays;

/**
 * <p>300. Longest Increasing Subsequence</p>
 * <p>Difficulty:Medium</p>
 * <p>Given an unsorted array of integers, find the length of longest increasing subsequence.</p>

 <p>For example,<br>
 Given [10, 9, 2, 5, 3, 7, 101, 18],<br>
 The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.</p>
 <p>Note that there may be more than one LIS combination, it is only necessary for you to return the length.</p>

 <p>Your algorithm should run in O(n^2) complexity.</p>

 <p>Follow up: Could you improve it to O(n log n) time complexity?</p>
 */
public class Solution {
	public int lengthOfLIS(int[] nums) {
		final int length = nums.length;
		if (length==0){
			return 0;
		}
		// len[i] = maximum length of subsequence, which last element is nums[i]
		int[] len = new int[length];
		len[0] = 1;
		int max = 1;
		for (int i=1; i<length; i++){
			len[i] = 1;
			for (int k=0; k<i; k++){
				if (nums[k]<nums[i]){
					len[i] = Math.max(len[i], len[k]+1);
				}
			}
			max = Math.max(max, len[i]);
		}
		return max;
	}

	public static void main(String[] args) {
		int[][] input = {
				{},
				{1,1},
				{1,2},
				{1,3,6,7,9,4,10,5,6},
				{10, 9, 2, 5, 3, 7, 101, 18},
				{1,3,6,7,9,4,10,5,6,7,9,10,12},
		};
		int[] expected = {0, 1, 2, 6, 4, 9};
		for (int i=0; i<input.length; i++) {
			System.out.println(Arrays.toString(input[i])+" -> "+new Solution().lengthOfLIS(input[i])+" ("+expected[i]+")");
		}
	}
}
