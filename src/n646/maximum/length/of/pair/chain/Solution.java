package n646.maximum.length.of.pair.chain;

import java.util.*;

/**
 * <p>646. Maximum Length of Pair Chain</p>
 * <p>You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.</p>
 * <p>Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.</p>
 * <p>Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.</p>
 * <p>Example 1:
 * <pre>Input: [[1,2], [2,3], [3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4]
 * Note:
 * The number of given pairs will be in the range [1, 1000].</pre></p>
 */
public class Solution {
	// sort pairs by first,second number
	// build the longest chain from the last pair to first pair
	// because pairs are sorted, maxChainLength can only grow, while we move backward
	// keep intermediate results in Map first number -> max chain length
	public int findLongestChain(int[][] pairs) {
		Comparator<int[]> cmp = new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int r = Integer.compare(o1[0], o2[0]);
				return r==0 ? Integer.compare(o1[1], o2[1]) : r;
			}
		};
		Arrays.sort(pairs, cmp);
		int len = pairs.length;
		int maxChainLength = 0;
		Map<Integer, Integer> result = new HashMap<>();
		result.put(pairs[len-1][0], 1);

		int key[] = new int[2];
		for (int i=len-2; i>=0; i--){
			key[0] = key[1] = pairs[i][1]+1;
			int k = Arrays.binarySearch(pairs, i+1, len, key, cmp);
			if (k<0){
				k = -k -1;
			}
			int chainLength = 1;
			if (k<len){
				chainLength += result.getOrDefault(pairs[k][0], 0);
			}
			maxChainLength = Math.max(maxChainLength, chainLength);
			result.put(pairs[i][0], maxChainLength);
		}
		return result.get(pairs[0][0]);
	}

	public static void main(String[] args) {
		//int[][] input = {{9,10},{-4,9},{-5,6},{-5,9},{8,9}};
		int[][] input = {{-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}};
		System.out.println(new Solution().findLongestChain(input));
	}
}
