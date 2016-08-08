package countandsay;
/**
 * <p>38. Count and Say
 * <p>The count-and-say sequence is the sequence of integers beginning as follows:
	<p>1, 11, 21, 1211, 111221, ...

<p>1 is read off as "one 1" or 11.
<p>11 is read off as "two 1s" or 21.
<p>21 is read off as "one 2, then one 1" or 1211.
<p>Given an integer n, generate the nth sequence.

<p>Note: The sequence of integers will be represented as a string.

 *
 */
public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for (int i=2; i<=n; i++){
            StringBuilder sb = new StringBuilder();
            // convert s to i+1
            int k = 0; 
            int len = s.length();
            while (k<len){
                int count = 1;
                char c = s.charAt(k);
                k++;
                while (k<len && c==s.charAt(k)){
                    k++;
                    count++;
                }
                sb.append(count).append(c);
            }
            s = sb.toString();
        }
        return s;
    }
}
