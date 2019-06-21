#include <string>
#include <vector>
#include <sstream>

using namespace std;
/**
Given words first and second, consider occurrences in some text of the form "first second third", where second comes immediately after first, and third comes immediately after second.

For each such occurrence, add "third" to the answer, and return the answer.



Example 1:

Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
Output: ["girl","student"]
Example 2:

Input: text = "we will we will rock you", first = "we", second = "will"
Output: ["we","rock"]


Note:

1 <= text.length <= 1000
text consists of space separated words, where each word consists of lowercase English letters.
1 <= first.length, second.length <= 10
first and second consist of lowercase English letters.
 */
class Solution {
public:
    vector<string> findOcurrences1(string text, string first, string second) {
        vector<string> result;
        string_view t{text};
        size_t pos = 0;
        while ((pos = t.find(first, pos))!=string_view::npos) {
            // move pos forward
            pos += first.size();
            // skip spaces
            pos = skipSpaces(t, pos);
            // check if second is here
            if (t.substr(pos, second.size()) == second) {
                // skip spaces
                size_t third_start = skipSpaces(t, pos + second.size());
                // find end of third
                size_t third_finish = t.find_first_of(" ", third_start);
                if (third_start != ((third_finish==string_view::npos)?t.size():third_finish)) {
                    result.push_back(text.substr(third_start, third_finish - third_start));
                }
            }
        }
        return result;
    }

    size_t skipSpaces(string_view s, size_t pos){
        while (pos<s.size() && s[pos] == ' '){
            pos++;
        }
        return pos;
    }
};
