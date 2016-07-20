package intersectionoftwoarrays;

import java.util.HashSet;
import java.util.Set;
/**
 * <p>349. Intersection of Two Arrays
 * <p><a href="https://leetcode.com/problems/intersection-of-two-arrays/">https://leetcode.com/problems/intersection-of-two-arrays/</a>
 * <p>Given two arrays, write a function to compute their intersection.

<p>Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

<p>Note:<ul>
<li>Each element in the result must be unique.
<li>The result can be in any order.
</ul>
 
 *
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // for performance reasons put smallest array into has set
    	if (nums1.length>nums2.length){
            int[] t = nums1;
            nums1 = nums2;
            nums2 = t;
        }
        Set<Integer> set = new HashSet<Integer>(nums1.length<<1);
        for (int i: nums1){
            set.add(i);
        }
        Set<Integer> common = new HashSet<Integer>(nums1.length<<1);
        for (int i: nums2){
            if (set.contains(i)){
                common.add(i);
            }
        }
        int[] result = new int[common.size()];
        int k = 0;
        for (Integer i: common){
            result[k++] = i;
        }
        return result;
    }
}
