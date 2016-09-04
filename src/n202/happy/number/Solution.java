package n202.happy.number;

import java.util.HashSet;
/**
 * <p>202. Happy Number  QuestionEditorial Solution  My Submissions
<p>Write an algorithm to determine if a number is "happy".
<p>A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

<p>Example: 19 is a happy number
<pre>
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
</pre>
 *
 */
public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> trail = new HashSet<Integer>();
        trail.add(0); // guarantee exit if n==0
        trail.add(1); // guarantee exit if n==1
        while(trail.add(n)){
            int x = 0;
            while(n>0){
                int r = n%10;
                x+=r*r;
                n=n/10;
            }
            n = x;
        }
        return n==1;
    }
}
