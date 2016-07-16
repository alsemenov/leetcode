package reverseinteger;
/**
 * <p>7. Reverse Integer
 * <p><a href="https://leetcode.com/problems/reverse-integer/">https://leetcode.com/problems/reverse-integer/</a>
 * <p>Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

<p> spoilers.

<p>Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

Update (2014-11-10):
Test cases had been added to test the overflow behavior.

 *
 */
public class Solution {
    public int reverse(int x) {
        int result = 0;
        int pOverflow = Integer.MAX_VALUE/10;
        int pDigit = Integer.MAX_VALUE%10;
        int nOverflow = Integer.MIN_VALUE/10;
        int nDigit = Integer.MIN_VALUE%10;
        while(x!=0) {
            int digit = x%10;
            if (result>pOverflow || (result==pOverflow && digit>pDigit)){
                return 0;
            }
            if (result<nOverflow ||(result==nOverflow && digit<nDigit)){
            	return 0;
            }
            result = result *10 + digit;
            x = x/10;
        }
        return result;
    }
}
