#include <string>
#include <algorithm>

using namespace std;
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
public:
    string gcdOfStrings(string str1, string str2) {
        size_t len1 = str1.size(), len2 = str2.size();
        if (len1 > len2) {
            str1.swap(str2);
            swap(len1, len2);
        }
        if (len1 > 0) {
            for (size_t i = 1; i<= len1; i++) {
                if (len1 % i == 0) {
                    string result{str1, 0, len1/i};
                    if (len2 % result.size() == 0 &&
                        divides(str1, result) && divides(str2, result)){
                        return result;
                    }
                }
            }
        }
        return "";
    }

    bool divides(string_view s, string_view d) {
        size_t len = d.size();
        size_t p = 0;
        while (p < s.size() && s.substr(p, len) == d){
            p+=len;
        }
        return p==s.size();
    }
};
