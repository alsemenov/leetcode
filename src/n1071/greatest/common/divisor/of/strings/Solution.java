package n1071.greatest.common.divisor.of.strings;

/**
 1071. Greatest Common Divisor of Strings

 For strings S and T, we say "T divides S" if and only if S = T + ... + T  (T concatenated with itself 1 or more times)

 Return the largest string X such that X divides str1 and X divides str2.

 Example 1:

 Input: str1 = "ABCABC", str2 = "ABC"
 Output: "ABC"
 Example 2:

 Input: str1 = "ABABAB", str2 = "ABAB"
 Output: "AB"
 Example 3:

 Input: str1 = "LEET", str2 = "CODE"
 Output: ""

 */
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        if (len1 > len2){
            String tmp = str1;
            str1 = str2;
            str2 = tmp;
            int t = len1;
            len1 = len2;
            len2 = t;
        }
        if (len1 > 0){
            for (int i = 1; i<=len1; i++){
                if (len1 % i == 0){
                    int resultLen = len1/i;
                    if (len2 % resultLen == 0 && divides(str1, str2, resultLen) && divides(str2, str1, resultLen)){
                        return str1.substring(0, resultLen);
                    }
                }
            }
        }
        return "";
    }

    private boolean divides(String s1, String s2, int dividerLength) {
        int p = 0;
        while (p < s1.length() && s1.regionMatches(false, p, s2, 0, dividerLength)) {
            p += dividerLength;
        }
        return p == s1.length();
    }

}
