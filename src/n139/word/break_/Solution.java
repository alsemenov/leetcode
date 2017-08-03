package n139.word.break_;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>139. Word Break</p>
 * <p>Difficulty:Medium</p>
 * <p>Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine
 * if s can be segmented into a space-separated sequence of one or more dictionary words.
 * You may assume the dictionary does not contain duplicate words.</p>
 * <p> For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".</p>
 */
public class Solution {
	// Naive solution via recursion and caching intermediate results
	private boolean wordBreak(String s, int offset, List<String> wordDict, Map<Integer,Boolean> cache) {
		if (cache.containsKey(offset)) {
			return cache.get(offset);
		}
		for (String word: wordDict) {
			int len = word.length();
			if (s.regionMatches(offset, word, 0, len) && wordBreak(s, offset+len, wordDict, cache)){
				cache.put(offset, true);
				return true;
			}
		}
		cache.put(offset, false);
		return false;
	}

	public boolean wordBreak1(String s, List<String> wordDict) {
		 Map<Integer,Boolean> cache = new HashMap<>();
		 cache.put(s.length(), true);
		 return wordBreak(s, 0, wordDict, cache);
	}

	// solution without recursion, using DP
	public boolean wordBreak2(String s, List<String> wordDict) {
		boolean[] result = new boolean[s.length()];
		for (int i=result.length-1; i>=0; i--) {
			result[i] = false;
			for (String word: wordDict){
				int len = word.length();
				if (s.regionMatches(i, word, 0, len)){
					if (i+len>=result.length || result[i+len]){
						result[i] = true;
						break;
					}
				}
			}
		}
		return result[0];
	}
}
