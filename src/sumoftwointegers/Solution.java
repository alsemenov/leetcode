package sumoftwointegers;
/**
 * <p>371. Sum of Two Integers
 * <p><a href="https://leetcode.com/problems/sum-of-two-integers/">https://leetcode.com/problems/sum-of-two-integers/</a>
 * <p>Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
<p>Example:
Given a = 1 and b = 2, return 3.
 *
 */
public class Solution {
	/**
	 * <p> 0 + 0 = 0, carry = 0
	 * <p> 0 + 1 = 1, carry = 0
	 * <p> 1 + 0 = 1, carry = 0
	 * <p> 1 + 1 = 0, carry = 1
	 * <p> sum = a ^ b
	 * <p> carry = a & b
	 * <p> result is sum + (carry<<1) 
	 * @param a
	 * @param b
	 * @return
	 */
    public int getSum(int a, int b) {
        do {    
            int c = a & b;
            a = a ^ b;
            b = c<<1;
        } while (b!=0);
        return a;
    }
}
