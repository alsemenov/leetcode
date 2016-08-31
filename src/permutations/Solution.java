package permutations;

import java.util.ArrayList;
import java.util.List;

/**
<p>46. Permutations  QuestionEditorial Solution  My Submissions
<p>Difficulty: Medium
<p>Given a collection of distinct numbers, return all possible permutations.

<p>For example,
[1,2,3] have the following permutations:
<pre>
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
<pre>
 *
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        dfs(result, current, nums);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> current, int[] nums){
    	int len = nums.length;
    	if (current.size()==len){
            result.add(new ArrayList<Integer>(current));
        } else {
            for (int k=0; k<nums.length; k++){
                if (!current.contains(nums[k])){
                    current.add(nums[k]);
                    dfs(result, current, nums);
                    current.remove(current.size()-1);
                }
            }
        }
    }
}
