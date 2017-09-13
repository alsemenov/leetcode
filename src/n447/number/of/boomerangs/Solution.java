package n447.number.of.boomerangs;

import java.util.HashMap;

/**
 * <p>447. Number of Boomerangs</p>
 * <p>Difficulty:Easy</p>
 * <p>Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k)
 * such that the distance between i and j equals the distance between i and k (the order of the tuple matters).</p>

 <p>Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in
 the range [-10000, 10000] (inclusive).</p>

 <p>Example:
 <pre>
 Input:
 [[0,0],[1,0],[2,0]]

 Output:
 2

 Explanation:
 The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]</pre></p>
 */
public class Solution {
	public int numberOfBoomerangs(int[][] points) {
		int count = 0;
		for (int[] p : points) {
			HashMap<Integer, Integer> d = new HashMap<>();
			for (int[] x: points){
				final int dx = p[0]-x[0];
				final int dy = p[1]-x[1];
				final int q = dx*dx + dy*dy;
				d.put(q, d.getOrDefault(q, 0)+1);
			}
			for (Integer n: d.values()){
				count += n*(n-1);
			}
		}
		return count;
	}
}
