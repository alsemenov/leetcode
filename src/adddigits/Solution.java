package adddigits;
/**
<p>258. Add Digits  Question
<p>Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

<p>For example:

<p>Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

<p>Follow up:
Could you do it without any loop/recursion in O(1) runtime?

 *
 */
public class Solution {
    public int addDigits(int num) {
        // the idea of the solution is following
    	// result can be only one of nine digits: 1 2 3 4 5 6 7 8 9
    	// lets assume that for some number N result is S
    	// then for N+1 result is
    	//    S<9 => S+1
    	//    S==9 => 1
    	// So we conclude that result is periodic with period equal to 9
    	// therefore for any given number N we need to find shift, i.e. N%9
    	// for cases N%9==0 we should return 9, except if N is zero
        int r = num%9;
        return (r!=0)?r:((num!=0)?9:0);
    }
}
