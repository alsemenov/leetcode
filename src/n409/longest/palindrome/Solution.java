package n409.longest.palindrome;

/**
 * <p>409. Longest Palindrome</p>
 * <p>Difficulty:Easy</p>
 * <p>Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.</p>

 <p>This is case sensitive, for example "Aa" is not considered a palindrome here.</p>

 <p>Note:
 Assume the length of given string will not exceed 1,010.</p>

 <p>Example:<br>

 Input:<br>
 "abccccdd"<br>

 Output:<br>
 7<br>

 Explanation:
 One longest palindrome that can be built is "dccaccd", whose length is 7.</p>
 */
public class Solution {
	public int longestPalindrome(String s) {
		final int[] q = new int['Z'-'A'+'z'-'a'+2];
		final int len = s.length();
		for (int i=0; i<len; i++){
			final char c = s.charAt(i);
			if (c>='A' && c<='Z') {
				q[c-'A']++;
			} else if (c>='a' && c<='z'){
				q[c-'a'+'Z'-'A'+1]++;
			}
		}
		int r = 0;
		for (int x : q){
			r += (x & 0xFFFFFFFE);
		}
		if (r<len){
			r++;
		}
		return r;
	}
}
