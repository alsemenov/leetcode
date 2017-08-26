package n414.third.maximum.number;
/**
 * <p>414. Third Maximum Number</p>
 * <p>Difficulty:Easy</p>
 * <p>Given a non-empty array of integers, return the third maximum number in this array. 
 * If it does not exist, return the maximum number. The time complexity must be in O(n).</p>

<p>Example 1:
<pre>
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.</pre></p>
<p>Example 2:
<pre>Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.</pre></p>
<p>Example 3:
<pre>Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.</pre></p>

 *
 */
public class Solution {
    public int thirdMax(int[] nums) {
        int max1 = 0, max2 = 0, max3 = 0;
        boolean f1 = false, f2 = false, f3 = false;
        for (int i=nums.length-1; i>=0; i--){
            final int v = nums[i];
            if ((f1 && v==max1)||(f2 && v==max2)||(f3 && v==max3)){
                continue;
            }
            
            if (!f1 || v>max1){                
                max3 = max2; f3 = f2;
                max2 = max1; f2 = f1;
                max1 = v; f1 = true;
            } else if (!f2 || v>max2){
                max3 = max2; f3 = f2;
                max2 = v; f2 = true;                
            } else if (!f3 || v>max3){
                max3 = v; f3 = true;
            }
        }
        return f3 ? max3 : max1;
    }
}
