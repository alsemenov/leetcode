package n283.move.zeroes;
/**
 * <p>283. Move Zeroes
 * <p><a href="https://leetcode.com/problems/move-zeroes/">https://leetcode.com/problems/move-zeroes/</a>
<p>Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

<p>For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

<p>Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 *
 */
public class Solution {
    public void moveZeroes(int[] num) {
        int len = num.length;
        if (len<=1){
            return;
        }
        
        int i = 0, k = 0;
        while (i<len){
            int x = num[i];
            if (x!=0){
                num[k] = x;
                k++;
            }
            i++;
        }
        while(k<len){
            num[k] = 0;
            k++;
        }
     }
}
