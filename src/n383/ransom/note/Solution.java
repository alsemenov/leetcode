package n383.ransom.note;

/**
 * <p>383. Ransom Note</p>
 * <p>Difficulty:Easy</p>
 * <p>Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines ;
 * otherwise, it will return false.</p>

 <p>Each letter in the magazine string can only be used once in your ransom note.</p>

 <p>Note:
 You may assume that both strings contain only lowercase letters.<br>

 canConstruct("a", "b") -> false<br>
 canConstruct("aa", "ab") -> false<br>
 canConstruct("aa", "aab") -> true<br>
 </p>
 */
public class Solution {
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] q = new int['z' - 'a' + 1];
		for (int i = magazine.length() - 1; i >= 0; i--) {
			q[magazine.charAt(i) - 'a']++;
		}
		int len = ransomNote.length();
		for (int i = 0; i < len; i++) {
			char c = ransomNote.charAt(i);
			if (q[c - 'a'] == 0) {
				return false;
			}
			q[c - 'a']--;
		}
		return true;
	}
}
