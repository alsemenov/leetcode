package n055.jump.game;
/**
<p>55. Jump Game
<p>Difficulty: Medium
<p>Given an array of non-negative integers, you are initially positioned at the first index of the array.

<p>Each element in the array represents your maximum jump length at that position.

<p>Determine if you are able to reach the last index.

<p>For example:
<p>A = [2,3,1,1,4], return true.

<p>A = [3,2,1,0,4], return false.
 *
 */
public class Solution {
	/**
	 * O(N) solution
	 * @param nums
	 * @return
	 */
    public boolean canJump(int[] nums) {
        int horizon = 0;
        int len = nums.length;
        for (int i=0; i<=horizon && i<len; i++){
            horizon = Math.max(horizon, i+nums[i]);
        }
        return horizon>=len-1;
    }
    /**
     * <p>this solution is not O(N) in worst case,
     * but leetcode says it beats 72.72% of java submissions.
     * <p> the idea is to look for cells with zero
     * and check if can jump over this cell from some previous position.
     * if we can not, then return false immediately.
     * @return
     */
    public boolean canJump2(int[] nums) {
       int len = nums.length;
       for (int i=0; i<len; i++){    	   
           if (nums[i]==0){
               int k;
               for (k=i-1; k>=0 && nums[k]<=i-k; k--);
               if (k<0){
                   return i==len-1;
               }
           }
       }
       return true;
    }
}
