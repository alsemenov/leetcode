from collections import defaultdict

class Solution(object):
    """
    14. Longest Common Prefix

    Write a function to find the longest common prefix string amongst an array of strings.
    """
    def longestCommonPrefixUsingTrie(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        trie = defaultdict(defaultdict)
        min_len = min(map(len, strs) or [0])
        for s in strs:
            p = trie
            depth = 0
            for c in s:
                if depth >= min_len:
                    break
                if len(p)==1 and p.keys()[0]!=c:
                    min_len = depth
                    break
                p = p[c]
                p.default_factory = defaultdict
                depth += 1

        p = trie
        r = ""
        l = 0
        while l<min_len and len(p)==1:
            c = p.keys()[0]
            r = r + c
            p = p[c]
            l += 1
        return r


    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """

        if len(strs) == 0:
            return ''

        prefix = min(strs, key=len)
        prefix_len = len(prefix)
        for s in strs:
            i = 0
            while i < prefix_len and s[i] == prefix[i]:
                i += 1
            prefix_len = min(i, prefix_len)

        return prefix[:prefix_len]


def main():
    input = [
        ["a"],[],["", "a"], ["a", "a"], ["a", ""],
             ["abc", "abcd", "abcde"], ["abc", "abcd", "abcde", "abe"]]
    for strs in input:
        print strs, Solution().longestCommonPrefix(strs)

# This is the standard boilerplate that calls the main() function.
if __name__ == '__main__':
  main()