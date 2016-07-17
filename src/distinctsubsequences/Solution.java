package distinctsubsequences;
/**
 * <p>115. Distinct Subsequences
 * <p><a href="https://leetcode.com/problems/distinct-subsequences/">https://leetcode.com/problems/distinct-subsequences/</a>
 * <p>Given a string S and a string T, count the number of distinct subsequences of T in S.
<p>A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
<p><pre>Here is an example:
S = "rabbbit", T = "rabbit"
Return 3.</pre>
 *
 */
public class Solution {
	// avoid using s.substring() because it involves coping necessary characters into new char array
    public int numDistinct(String s, String t) {
    	char[] sChars = s.toCharArray();
		char[] tChars = t.toCharArray();
		int[][] cache = new int[sChars.length][tChars.length];
		for (int i=0; i<cache.length; i++){
			for (int k=0; k<cache[0].length; k++){
				cache[i][k] = -1;
			}
		}
		return numDistinct(sChars,0, tChars, 0, cache);
    }
    
    /**
     * the idea of the solution is to use recursion
     * 1. if t is empty - it is a match, return 1
     * 2. if s is empty - it is no math, return 0
     * 3. take first characters of s and t
     * 4. if characters are equal then 
     *      result is numDistinct(s.substring(1),t) + numDistinct(s.substring(1),t.substring(1))
     *    else 
     *      result is numDistinct(s.substring(1),t)
     *      
     * Use cache to reuse already calculated results.     
     */
    private int numDistinct(char[] s, int sOffset, char[] t, int tOffset, int[][] cache){
    	int sLength = s.length - sOffset;
    	int tLength = t.length - tOffset;
    	if (tLength>sLength){
    		return 0;
    	}
    	if (tLength==0){
    		return 1;
    	}
    	if (sLength==0){
    		return 0;
    	}
    	
    	if (cache[sOffset][tOffset]!=-1){
    		return cache[sOffset][tOffset];
    	}
    	int sOffsetOriginal = sOffset;
    	
    	while (sOffset<s.length && s[sOffset]!=t[tOffset]){
    		sOffset++;
    	}
    	int result = 0;
    	if (sOffset<s.length){
    		result = numDistinct(s, sOffset+1, t, tOffset, cache) +
    			numDistinct(s, sOffset+1, t, tOffset+1, cache);
    	} 
    	for (int i=sOffsetOriginal; i<cache.length && i<=sOffset; i++){
    		cache[i][tOffset] = result;
    	}
    	return result;
    }
    
    public static void main(String[] args){
    	long start = System.currentTimeMillis();
//    	int r = new Solution().numDistinct("aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe",
//    			"bddabdcae");
    	
//    	int r = new Solution().numDistinct("daacaedaceacabbaabdccdaaeaebacddadcaeaacadbceaecddecdeedcebcdacdaebccdeebcbdeaccabcecbeeaadbccbaeccbbdaeadecabbbedceaddcdeabbcdaeadcddedddcececbeeabcbecaeadddeddccbdbcdcbceabcacddbbcedebbcaccac"
//    				,"ceadbaa");

//    	int r = new Solution().numDistinct("bbaa","ba");

    	int r = new Solution().numDistinct("adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc"
    				,"bcddceeeebecbc"); 
    				
    	long finish = System.currentTimeMillis();
		System.out.println(r+" "+(finish-start)+" ms");
    }
}
