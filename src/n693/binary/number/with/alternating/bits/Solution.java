package n693.binary.number.with.alternating.bits;

/**
 * <p>693. Binary Number with Alternating Bits</p>
 * <p>Difficulty: Easy</p>
 * <p>Given a positive integer, check whether it has alternating bits or not.</p>

 <p>Example 1:<pre>
 Input: 5
 Output: True
 Explanation:
 The binary representation of 5 is: 101</pre></p>
 <p>Example 2:<pre>
 Input: 7
 Output: False
 Explanation:
 The binary representation of 7 is: 111</pre></p>
 */
public class Solution {

    public boolean hasAlternatingBits(int n) {
        int z = n ^ (n>>1);
        return (z & (z+1)) == 0 && n!=0;
    }

    public static void main(String[] args) {
        System.out.println("0 "+new Solution().hasAlternatingBits(0)+" (false)");
        System.out.println("1 "+new Solution().hasAlternatingBits(1)+" (true)");
        System.out.println("2 "+new Solution().hasAlternatingBits(2)+" (true)");
        System.out.println("3 "+new Solution().hasAlternatingBits(3)+" (false)");
        System.out.println("4 "+new Solution().hasAlternatingBits(4)+" (false)");
        System.out.println("5 "+new Solution().hasAlternatingBits(5)+" (true)");
        System.out.println("7 "+new Solution().hasAlternatingBits(7)+" (false)");
        System.out.println("10 "+new Solution().hasAlternatingBits(10)+" (true)");
    }
}
