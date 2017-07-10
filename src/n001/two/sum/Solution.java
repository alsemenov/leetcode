package n001.two.sum;

/**
 * <p>1. Two Sum</p>
 * <p>Difficulty: Easy</p>
 * <p>Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.</p>
 <p>Example:
 <pre>Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].</pre>
 </p>
 */
public class Solution {
	public int[] twoSum(int[] nums, int target) {
		for (int i=0; i<nums.length; i++){
			int x = target - nums[i];
			int k = i + 1;
			for(; k<nums.length && x!=nums[k]; k++);
			if (k<nums.length && x==nums[k]){
				return new int[]{i, k};
			}
		}
		return null;
	}
}
