package n453.minimum.moves.to.equal.array.elements;

/**
 * <p>453. Minimum Moves to Equal Array Elements</p>
 * <p>Difficulty:Easy</p>
 * <p>Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements
 * equal, where a move is incrementing n - 1 elements by 1.</p>

 <p>Example:
<pre>
 Input:
 [1,2,3]

 Output:
 3

 Explanation:
 Only three moves are needed (remember each move increments two elements):

 [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]</pre></p>
 */
public class Solution {
	/**
	 * Adding 1 to n-1 elements is equivalent to subtracting 1 from single element and adding 1 to all elements.
	 * At the end all elements will be equal to min element plus number of steps.
	 * We need to count sum(nums[i]-min) to get the answer.
	 * sum(nums[i]-min) = sum(nums[i]) - min*nums.length
	 */
	public int minMoves(int[] nums) {
		final int len = nums.length;
		if (len==0){
			return 0;
		}
		int sum = 0; // could be long to avoid overflow
		int min = nums[0];
		for (int n: nums){
			min = Math.min(min,n);
			sum+=n;
		}
		return (sum - len*min);
	}
}
