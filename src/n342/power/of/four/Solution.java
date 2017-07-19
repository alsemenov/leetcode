package n342.power.of.four;
/**
 * <p>342. Power of Four 
 * <p>Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

<p>Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?
 *
 */
public class Solution {
    public boolean isPowerOfFour(int num) {
        // (num & (num-1))==0 checks that num has only single bit set, i.e. is power of two
    	// (num & 0x55555555)!=0 checks that the bit is in the right position
    	return num==1 || ((num & (num-1))==0 && (num & 0x55555555)!=0);
    }
}
