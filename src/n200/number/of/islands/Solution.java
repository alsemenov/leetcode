package n200.number.of.islands;

import java.util.ArrayDeque;

/**
 * <p>200. Number of Islands</p>
 * <p>Difficulty:Medium</p>
 * <p>Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.</p>

 <p>Example 1:
 <pre>
 11110
 11010
 11000
 00000
 </pre>
 Answer: 1</p>

 <p>Example 2:
 <pre>
 11000
 11000
 00100
 00011
 </pre>
 Answer: 3</p>
 */
public class Solution {

	public int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int k = 0; k < grid[0].length; k++) {
				if (grid[i][k] == '1') {
					count++;
					markLand(grid, i, k);
				}
			}
		}
		return count;
	}

	/**
	 * Recursive version, using DFS
	 * @param grid
	 * @param i
	 * @param k
	 */
	private void markLand(char[][] grid, int i, int k){
		if (i<0 || k<0 || i>=grid.length || k>=grid[0].length || grid[i][k]!='1'){
			return;
		}
		grid[i][k] = 'x';

		markLand(grid, i+1, k);
		markLand(grid, i-1, k);
		markLand(grid, i, k+1);
		markLand(grid, i, k-1);
	}

	/**
	 * Non-recursive version, using BFS
	 * @param grid
	 * @param start
	 */
	void markLand(char[][] grid, int[] start){
		final ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(start);
		while (!queue.isEmpty()) {
			final int[] land = queue.removeFirst();
			final int up = land[0]-1;
			final int down = land[0]+1;
			final int left = land[1]-1;
			final int right = land[1]+1;
			if (up>=0 && grid[up][land[1]]=='1'){
				queue.add(new int[]{up,land[1]});
			}
			if (left>=0 && grid[land[0]][left]=='1'){
				queue.add(new int[]{land[0], left});
			}
			if (down<grid.length && grid[down][land[1]]=='1'){
				queue.add(new int[]{down, land[1]});
			}
			if (right<grid[0].length && grid[land[0]][right]=='1'){
				queue.add(new int[]{land[0], right});
			}
			grid[land[0]][land[1]] = 'x';
		}
	}

	public static void main(String[] args) {
//		char[][] input = {
//				"11110".toCharArray(),
//				"11010".toCharArray(),
//				"11000".toCharArray(),
//				"00000".toCharArray()
//		};
//		char[][] input = {
//				"111".toCharArray(),
//				"010".toCharArray(),
//				"111".toCharArray()
//		};

		String[] in = {
				"11111011111111101011",
				"01111111111110111110",
				"10111001101111111111",
				"11110111111111111111",
				"10011111111111111111",
				"10111111011101110111",
				"01111111111101101111",
				"11111111111101111011",
				"11111111110111111111",
				"11111111111111111111",
				"01111111011111111111",
				"11111111111111111111",
				"11111111111111111111",
				"11111011111110111111",
				"10111110111011110111",
				"11111111111101111110",
				"11111111111110111100",
				"11111111111111111111",
				"11111111111111111111",
				"11111111111111111111"
		};
		char[][] input = new char[in.length][];
		int i = 0;
		for (String s: in){
			input[i] = s.toCharArray();
			i++;
		}

		System.out.println(new Solution().numIslands(input));
	}
}
