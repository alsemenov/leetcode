class Solution(object):
    def isPalindrome(self, x):
        """
        9. Palindrome Number

        Determine whether an integer is a palindrome. Do this without extra space.
        :type x: int
        :rtype: bool
        """
        if x < 0:
            return False
        if x < 10:
            return True
        y = 0
        while x:
            x, r = divmod(x, 10)
            z = y * 10 + r
            if x!=0 and (x==y or x==z):
                return True
            if y==0 and r==0:
                return False
            y = z
        return False

def main():
    for x in [-1,0, 3, 33, 121, 10, 15, 1551, 15151, 15252, -2147483648, 2147483647, 21120, 2102012, 1001]:
        print x, Solution().isPalindrome(x)

# This is the standard boilerplate that calls the main() function.
if __name__ == '__main__':
  main()
