package n660.remove._9;
/**
 * <p>660. Remove 9</p>
 * <p>Difficulty: Hard</p>
 * <p>Start from integer 1, remove any integer that contains 9 such as 9, 19, 29...</p>
 * <p>So now, you will have a new integer sequence: 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, ...</p>
 * <p>Given a positive integer n, you need to return the n-th integer after removing. Note that 1 will be the first integer.</p>

<p>Example 1:<br>
Input: 9<br>
Output: 10</p>
<p>Hint: n will not exceed 9 x 10^8.</p>
 *
 */
public class Solution {
    public int newInteger(int n) {
        int r = 0;
        int b = 1;
        while (n!=0){
            r = r + (n%9)*b;
            n = n/9;
            b = b*10;
        }
        return r;
    }
}
