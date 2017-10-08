package n695.max.area.of.island;

/**
 * <p>695. Max Area of Island</p>
 * <p>Difficulty: Easy</p>
 * <p>Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's
 * (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.</p>
 * <p>Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)</p>

 <p>Example 1:<pre>
 [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.</pre></p>
 <p>Example 2:<pre>
 [[0,0,0,0,0,0,0,0]]
 Given the above grid, return 0.
 Note: The length of each dimension in the given grid does not exceed 50.</pre></p>
 *
 */
public class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int k = 0; k < grid[0].length; k++) {
                if (grid[i][k] == 1) {
                    max = Math.max(max, markLand(grid, i, k));
                }
            }
        }
        return max;
    }


    private int markLand(int[][] grid, int i, int k){
        if (i<0 || k<0 || i>=grid.length || k>=grid[0].length || grid[i][k]!=1){
            return 0;
        }

        grid[i][k] = -1;
        return 1+
        markLand(grid, i+1, k) +
        markLand(grid, i-1, k) +
        markLand(grid, i, k+1) +
        markLand(grid, i, k-1);
    }


    public static void main(String[] args) {
        int[][] in = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                     {0,0,0,0,0,0,0,1,1,1,0,0,0},
                     {0,1,1,0,1,0,0,0,0,0,0,0,0},
                     {0,1,0,0,1,1,0,0,1,0,1,0,0},
                     {0,1,0,0,1,1,0,0,1,1,1,0,0},
                     {0,0,0,0,0,0,0,0,0,0,1,0,0},
                     {0,0,0,0,0,0,0,1,1,1,0,0,0},
                     {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        System.out.println(new Solution().maxAreaOfIsland(in));

        int[][] in2 = {{0,0,0,0,0}};
        System.out.println(new Solution().maxAreaOfIsland(in2));
        int[][] in3 = {{1,1,0,1,0}};
        System.out.println(new Solution().maxAreaOfIsland(in3));
    }
}
