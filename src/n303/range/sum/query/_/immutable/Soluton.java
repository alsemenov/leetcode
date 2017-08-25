package n303.range.sum.query._.immutable;

/**
 * <p>303. Range Sum Query - Immutable</p>
 * <p>Difficulty:Easy</p>
 * <p>Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.</p>

 <p>Example:
 <pre>
 Given nums = [-2, 0, 3, -5, 2, -1]

 sumRange(0, 2) -> 1
 sumRange(2, 5) -> -1
 sumRange(0, 5) -> -3</pre></p>
 <p>Note:<ol>
 <li>You may assume that the array does not change.</li>
 <li>There are many calls to sumRange function.</li></ol></p>
 */
public class Soluton {
	class NumArray {
		private final int[] incSum;

		public NumArray(int[] nums) {
			incSum = new int[nums.length+1];
			for (int i=1; i<=nums.length; i++){
				incSum[i] = incSum[i-1] + nums[i-1];
			}
		}

		public int sumRange(int i, int j) {
			return incSum[j+1] - incSum[i];
		}
	}
}
