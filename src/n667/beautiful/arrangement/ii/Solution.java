package n667.beautiful.arrangement.ii;

import java.util.Arrays;

/**
 * <p>667. Beautiful Arrangement II</p>
 * <p>Difficulty: Medium</p>
 * <p>Given two integers n and k, you need to construct a list which contains n different positive integers
 * ranging from 1 to n and obeys the following requirement: Suppose this list is [a1, a2, a3, ... , an],
 * then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.</p>

 <p>If there are multiple answers, print any of them.</p>

 <p>Example 1:<br>
 Input: n = 3, k = 1<br>
 Output: [1, 2, 3]<br>
 Explanation: The [1, 2, 3] has three different positive integers ranging from 1 to 3, and the [1, 1] has exactly 1 distinct integer: 1.</p>
 <p>Example 2:<br>
 Input: n = 3, k = 2<br>
 Output: [1, 3, 2]<br>
 Explanation: The [1, 3, 2] has three different positive integers ranging from 1 to 3, and the [2, 1] has exactly 2 distinct integers: 1 and 2.</p>
 <p>Note:
 The n and k are in the range 1 <= k < n <= 104.</p>
 */
public class Solution {

    public int[] constructArray(int n, int k) {

        int[] r = new int[n];

        for (int i=k+1; i<n; i++){
            r[i] = i+1;
        }

        r[0] = 1;
        int j = 1;
        boolean sign = true;
        for (int i=k; i>0; i--){
            if (sign) {
                r[j] = r[j - 1] + i;
            } else {
                r[j] = r[j - 1] - i;
            }
            sign = !sign;
            j++;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().constructArray(5,3)));
    }
}
