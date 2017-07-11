package n031.next.permutation;

import java.util.Arrays;
/**
<p>031. Next Permutation  QuestionEditorial Solution  My Submissions
<p>Difficulty: Medium
<p>Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

<p>If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

<p>The replacement must be in-place, do not allocate extra memory.

<p>Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
<p>1,2,3 → 1,3,2
<p>3,2,1 → 1,2,3
<p>1,1,5 → 1,5,1

 *
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        
        // go from left to right until l>r
        int i = len - 1;
        while (i>0 && nums[i-1]>=nums[i]){
            i--;
        }
        if (i>0){
            // increase nums[i-1]
            int x = nums[i-1];
            // find replacement for x
            int k;
            for (k=len-1; k>=i && x>=nums[k]; k--);
            nums[i-1] = nums[k];
            nums[k] = x;
        }
        // reverse [i,len]
        int k = i, z = len-1;
        while(k<z){
            int x = nums[k];
            nums[k] = nums[z];
            nums[z] = x;
            k++;
            z--;
        }
    }
    
    public static void main(String[] args){
    	int[] nums = {1,2};
    	new Solution().nextPermutation(nums);
    	System.out.println(Arrays.toString(nums));
    }
}
