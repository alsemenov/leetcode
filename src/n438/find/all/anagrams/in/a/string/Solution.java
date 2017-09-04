package n438.find.all.anagrams.in.a.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>438. Find All Anagrams in a String</p>
 * <p>Difficulty:Easy</p>
 * <p>Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.</p>

 <p>Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.</p>

 <p>The order of output does not matter.</p>

 <p>Example 1:
<pre>
 Input:
 s: "cbaebabacd" p: "abc"

 Output:
 [0, 6]

 Explanation:
 The substring with start index = 0 is "cba", which is an anagram of "abc".
 The substring with start index = 6 is "bac", which is an anagram of "abc".</pre></p>
 <p>Example 2:
<pre>
 Input:
 s: "abab" p: "ab"

 Output:
 [0, 1, 2]

 Explanation:
 The substring with start index = 0 is "ab", which is an anagram of "ab".
 The substring with start index = 1 is "ba", which is an anagram of "ab".
 The substring with start index = 2 is "ab", which is an anagram of "ab".</pre></p>
 */
public class Solution {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		int[] pq = new int['z'-'a'+1];
		for (int i=p.length()-1; i>=0; i--){
			pq[p.charAt(i)-'a']++;
		}
		int[] sq = new int['z'-'a'+1];
		int i=0, k = p.length();
		final int len = s.length();
		for(; i<len && i<k; i++) {
			sq[s.charAt(i)-'a']++;
		}
		if (Arrays.equals(sq, pq)){
			result.add(0);
		}
		i=0;
		while (k<len) {
			sq[s.charAt(i)-'a']--;
			sq[s.charAt(k)-'a']++;
			if (Arrays.equals(sq, pq)){
				result.add(i+1);
			}
			i++;
			k++;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().findAnagrams("cbaebabacd",	"abc"));
	}
}
