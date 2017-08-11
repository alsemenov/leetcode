package n643.maximum.average.subarray.i;

/**
 * <p>643. Maximum Average Subarray I</p>
 * <p>Difficulty:Easy</p>
 * <p>Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum
 * average value. And you need to output the maximum average value.</p>

 <p>Example 1:<br>
 Input: [1,12,-5,-6,50,3], k = 4<br>
 Output: 12.75<br>
 Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75</p>
 <p>Note:
 1 <= k <= n <= 30,000.
 Elements of the given array will be in the range [-10,000, 10,000].</p>
 */
public class Solution {
	public double findMaxAverage(int[] nums, int k) {
		int sum = 0;
		for(int j=0; j<k; j++){
			sum+=nums[j];
		}
		int max = sum;
		for(int j=k; j<nums.length; j++){
			sum = sum + nums[j] - nums[j-k];
			max = Math.max(max,sum);
		}
		return ((double)max)/k;
	}
}
