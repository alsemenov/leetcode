package n633.sum.of.square.numbers;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>633. Sum of Square Numbers</p>
 * <p>Difficulty:Easy</p>
 * <p>Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.</p>
 <p>Example 1:<br>
 Input: 5<br>
 Output: True<br>
 Explanation: 1 * 1 + 2 * 2 = 5<br></p>
 <p>Example 2:<br>
 Input: 3<br>
 Output: False</p>
 */
public class Solution {
	public boolean judgeSquareSum(int c) {
		Set<Integer> set = new HashSet<Integer>();
		double limit = Math.sqrt(c);
		int sq, i = 0;
		do {
			sq = i*i;
			set.add(sq);
			i++;
		} while (i-1<=limit && !set.contains(c-sq));
		return set.contains(c-sq);
	}

	public static void main(String[] args) {
		final Solution solution = new Solution();
		long start = System.currentTimeMillis();
		final boolean b = solution.judgeSquareSum(Integer.MAX_VALUE);
		long finish = System.currentTimeMillis();
		System.out.println("result: "+b+" "+(finish-start)+" ms");
	}
}
