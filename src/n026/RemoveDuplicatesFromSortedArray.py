class Solution(object):
    """26. Remove Duplicates from Sorted Array"""
    def removeDuplicates(self, nums):
        """Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.

        Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
        Example:
            Given nums = [1,1,2],

            Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
            It doesn't matter what you leave beyond the new length.

        :type nums: List[int]
        :rtype: int
        """
        i, k, length = 0, 1, len(nums)
        if length==0:
            return 0
        while k<length:
            if nums[i]!=nums[k]:
                i += 1
                if i!=k:
                    nums[i] = nums[k]
            k += 1
        return i + 1


def main():
    input = [[], [1], [1,2], [1,1,2], [1,1,1], [1,1,2,2,3,3], [1,2,2,2,2]]
    for i in input:
        print i, Solution().removeDuplicates(i), i

if __name__=='__main__':
    main()