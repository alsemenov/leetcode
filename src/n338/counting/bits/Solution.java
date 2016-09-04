package n338.counting.bits;
/**
 * <p>338. Counting Bits
 * <p>Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

<p>Example:
<p>For num = 5 you should return [0,1,1,2,1,2].

<p>Follow up:
<ul>
<li>It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
<li>Space complexity should be O(n).
<li>Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
</ul>
 *
 */
public class Solution {
    public int[] countBits(int num) {
        assert(num>=0);
    	int[] result = new int[num+1];
        result[0] = 0;
        int power2 = 1;
        for (int i=1; i<=num; i++){
            int p = i-1;
            // if ((p&1)==0){   // this case can be omitted
            //     result[i] = result[p]+1;
            // } else 
            if ((i&p)==0){ // if i is power of 2 there is only one bit 
                result[i] = 1;
                power2 = i;
            } else {
                result[i] = result[i-power2]+1; // clear most significant bit and by subtracting power2
            }
        }
        return result;
    }
}
