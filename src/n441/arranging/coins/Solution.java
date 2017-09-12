package n441.arranging.coins;

/**
 * <p>441. Arranging Coins</p>
 * <p>Difficulty:Easy</p>
 * <p>You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

 <p>Given n, find the total number of full staircase rows that can be formed.</p>

 <p>n is a non-negative integer and fits within the range of a 32-bit signed integer.</p>

 <p>Example 1:
<pre>
 n = 5

 The coins can form the following rows:
 ¤
 ¤ ¤
 ¤ ¤

 Because the 3rd row is incomplete, we return 2.</pre></p>
 <p>Example 2:
<pre>
 n = 8

 The coins can form the following rows:
 ¤
 ¤ ¤
 ¤ ¤ ¤
 ¤ ¤

 Because the 4th row is incomplete, we return 3.</pre></p>
 */
public class Solution {
	/**
	 * sum(1+2+3+..x) < n
	 * x*(x+1) < n
	 * x = (-1 +- sqrt(1+8*n))/2
	 * ignore negative root, round positive root to integer
	 */
	public int arrangeCoins(int n) {
		return (int) Math.floor((-1 + Math.sqrt(1+(8*(double)n)))/2);
	}
}
