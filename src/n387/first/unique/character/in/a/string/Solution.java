package n387.first.unique.character.in.a.string;

/**
 * <p>387. First Unique Character in a String</p>
 * <p>Difficulty:Easy</p>
 * <p>Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.</p>

 <p>Examples:<br>

 s = "leetcode"
 return 0.<br>

 s = "loveleetcode",
 return 2.</p>
 <p>Note: You may assume the string contain only lowercase letters.</p>
 */
public class Solution {
	public int firstUniqChar(String s) {
		final int[] q = new int['z'-'a'+1];
		final int len = s.length();
		for (int i=0; i<len; i++){
			q[s.charAt(i)-'a']++;
		}
		for (int i=0; i<len; i++){
			if (q[s.charAt(i)-'a']==1){
				return i;
			}
		}
		return -1;
	}
}
