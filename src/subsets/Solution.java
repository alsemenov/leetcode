package subsets;

import java.util.ArrayList;
import java.util.List;
/**
 * <p>78. Subsets
 * <p><a href="https://leetcode.com/problems/subsets/">https://leetcode.com/problems/subsets/</a>
 * <p><pre>
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
</pre>
 *
 */
public class Solution {

	public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, nums.length);
    }
    
    List<List<Integer>> subsets(int[] nums, int tailOffset){
        if (tailOffset>0){
            tailOffset--;
            List<List<Integer>> result = subsets(nums, tailOffset);
            int n = result.size();
            for (int i=0; i<n; i++){
                List<Integer> list = new ArrayList<Integer>(result.get(i));
                list.add(nums[tailOffset]);
                result.add(list);
            }
            return result;
        } else {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            result.add(new ArrayList<Integer>());
            return result;
        }
    }
}
