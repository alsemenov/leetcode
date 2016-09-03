package n179.largest.number;

import java.util.Arrays;
import java.util.Comparator;
/**
<p>179. Largest Number 
<p>Difficulty: Medium
<p>Given a list of non negative integers, arrange them such that they form the largest number.

<p>For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

<p>Note: The result may be very large, so you need to return a string instead of an integer.
 *
 */
public class Solution {
    public String largestNumber(int[] nums) {
        String s[] = new String[nums.length];
        int sum = 0;
        for (int i=nums.length-1; i>=0; i--){
            s[i] = Integer.toString(nums[i]);
            sum+=nums[i];
        }
        // if input is all zeros, return just "0"
        if (sum==0){
            return "0";
        }
        // if input contains something along with zeroes, this something will be before zeores
        
        // It seems that using natural order of String will give right result
        // However, example [121,12] -> "12|121" shows that it is wrong assumption
        // Also example [123,12] -> "123|12" shows that order is not easy to understand
        // So use just straight forward comparison
        Arrays.sort(s, new Comparator<String>() {
            public int compare(String s1, String s2){
                String x1 = s1+s2;
                String x2 = s2+s1;
                return x1.compareTo(x2);
            }    
        });
        StringBuilder sb = new StringBuilder();
        for (int i=s.length-1; i>=0; i--){
            sb.append(s[i]);
        }
        return sb.toString();
    }
}
