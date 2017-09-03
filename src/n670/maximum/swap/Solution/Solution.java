package n670.maximum.swap.Solution;

/**
 * <p>670. Maximum Swap</p>
 * <p>Difficulty: Medium</p>
 * <p>Given a non-negative integer, you could swap two digits at most once to get the maximum valued number.
 * Return the maximum valued number you could get.

 <p>Example 1:<br>
 Input: 2736<br>
 Output: 7236<br>
 Explanation: Swap the number 2 and the number 7.</p>
 <p>Example 2:<br>
 Input: 9973<br>
 Output: 9973<br>
 Explanation: No swap.</p>
 <p>Note:
 The given number is in the range [0, 10^8]</p>
 */
public class Solution {
    /**
     * Find maximum digit and swap it to be the first digit in number.
     * If it is already first digit, solve the same problem for number without the first digit.
     */
    public int maximumSwap(int num) {
        final char[] s = Integer.toString(num).toCharArray();
        maxSwap(s, 0);
        return Integer.parseInt(new String(s));
    }

    private void maxSwap(char[] s, int start) {
        if (start>=s.length){
            return;
        }
        int maxIndex = start;
        for (int i=start; i<s.length; i++){
            if (s[maxIndex]<=s[i]){
                maxIndex = i;
            }
        }
        if (s[maxIndex]==s[start]){
            maxSwap(s, start+1);
            return;
        }
        int i=start;
        for (; i<maxIndex && s[i]==s[maxIndex]; i++);
        if (i<maxIndex){
            char t = s[i];
            s[i] = s[maxIndex];
            s[maxIndex] = t;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumSwap(2736));
        System.out.println(solution.maximumSwap(9973));
        System.out.println(solution.maximumSwap(11199));
        System.out.println(solution.maximumSwap(7873));
        System.out.println(solution.maximumSwap(91235));
        System.out.println(solution.maximumSwap(951234));
        System.out.println(solution.maximumSwap(99901));
    }
}
