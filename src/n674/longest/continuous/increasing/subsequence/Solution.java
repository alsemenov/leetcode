package n674.longest.continuous.increasing.subsequence;

/**
 * <p>674. Longest Continuous Increasing Subsequence</p>
 * <p>Difficulty:Easy</p>
 * <p>Given an unsorted array of integers, find the length of longest continuous increasing subsequence.</p>

 <p>Example 1:
 <pre>
 Input: [1,3,5,4,7]
 Output: 3
 Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
 Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.</pre></p>
 <p>Example 2:
 <pre>
 Input: [2,2,2,2,2]
 Output: 1
 Explanation: The longest continuous increasing subsequence is [2], its length is 1.</pre></p>
 <p>Note: Length of the array will not exceed 10,000.</p>
 */
public class Solution {
	public int findLengthOfLCIS1(int[] nums) {
		 final int len = nums.length;
		 if (len==0){
		     return 0;
		 }
		 int count = 1, max = 1;
		 for (int i=1; i<len; i++){
		     if (nums[i]>nums[i-1]){
		         count++;
		     } else {
		         count = 1;
		     }
		     max = Math.max(max, count);
		 }
		 return max;
	}

	public int findLengthOfLCIS2(int[] nums) {
		final int len = nums.length;
		int count = 0, max = 0;
		for (int i=0; i<len; i++){
			count = (i==0 || nums[i-1]>=nums[i]) ? 1 : count+1;
			max = Math.max(max, count);
		}
		return max;
	}
}
