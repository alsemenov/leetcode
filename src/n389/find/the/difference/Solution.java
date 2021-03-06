package n389.find.the.difference;

/**
 * <p>389. Find the Difference</p>
 * <p>Difficulty:Easy</p>
 * <p>Given two strings s and t which consist of only lowercase letters.</p>
 * <p>String t is generated by random shuffling string s and then add one more letter at a random position.</p>
 * <p>Find the letter that was added in t.</p>
 * <p>Example:<br>
 Input:<br>
 s = "abcd"<br>
 t = "abcde"<br>

 Output:<br>
 e<br>

 Explanation:
 'e' is the letter that was added.
 </p>
 */
public class Solution {
	public char findTheDifference(String s, String t) {
		int c = 0;
		final int len = s.length();
		for (int i=len-1; i>=0; i--){
			c+= t.charAt(i) - s.charAt(i); // using xor is more safe for long lines
		}
		c+=t.charAt(len);
		return (char)c;
	}
}
