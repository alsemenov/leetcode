package n594.longest.harmonious.subsequence;

import java.util.HashMap;

/**
 * <p>594. Longest Harmonious Subsequence</p>
 * <p>Difficulty:Easy</p>
 * <p>We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.</p>
 * <p>Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its
 * possible <a href="https://en.wikipedia.org/wiki/Subsequence">subsequences</a>.</p>
 * <p>Example 1:<br>
 Input: [1,3,2,2,5,2,3,7]<br>
 Output: 5<br>
 Explanation: The longest harmonious subsequence is [3,2,2,2,3].</p>
 <p>Note: The length of the input array will not exceed 20,000.</p>
 */
public class Solution {
	public int findLHS(int[] nums) {
		HashMap<Integer,Integer> map = new HashMap<>();
		int max = 0;
		for (int i: nums){
			map.put(i, map.getOrDefault(i,0)+1);
		}

		for (Integer i: map.keySet()){
			if (map.containsKey(i+1)){
				max = Math.max(map.get(i)+map.get(i+1), max);
			}
		}
		return max;
	}
}
