class Solution(object):
    """
    13. Roman to Integer

    Given a roman numeral, convert it to an integer.
    Input is guaranteed to be within the range from 1 to 3999.

    """

    nums = {"I": 1, "V": 5, "X": 10, "L": 50, "C": 100, "D": 500, "M": 1000}

    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        last = None
        result = 0
        for c in reversed(s):
            n = self.nums[c]
            if last and last>n:
                result = result - n
                last = None
            else:
                result = result + n
                last = n

        return result

def main():
    for x in ["I", "II", "IV", "MMMCMXCIX", "CCLXXXIII", "MCMLXXXVIII"]:
        print Solution().romanToInt(x)

# This is the standard boilerplate that calls the main() function.
if __name__ == '__main__':
  main()
