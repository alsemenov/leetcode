package n666.path.sum.iv;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>666. Path Sum IV</p>
 * <p>Difficulty: Medium</p>
 * <p>If the depth of a tree is smaller than 5, then this tree can be represented by a list of three-digits integers.</p>

 <p>For each integer in this list:<ol>
 <li>The hundreds digit represents the depth D of this node, 1 <= D <= 4.</li>
 <li>The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8. The position is the same as that in a full binary tree.</li>
 <li>The units digit represents the value V of this node, 0 <= V <= 9.</li>
 <li>Given a list of ascending three-digits integers representing a binary with the depth smaller than 5. You need to return the sum of all paths from the root towards the leaves.</li></ol></p>

 <p>Example 1:
 <pre>Input: [113, 215, 221]
 Output: 12
 Explanation:
 The tree that the list represents is:
   3
  / \
 5   1

 The path sum is (3 + 5) + (3 + 1) = 12.
 </pre></p>
 <p>Example 2:
 <pre>
 Input: [113, 221]
 Output: 4
 Explanation:
 The tree that the list represents is:
  3
   \
    1

 The path sum is (3 + 1) = 4.</pre></p>
 */
public class Solution {

    public int pathSum(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int[] result = new int[1];
        Map<Integer, Integer> tree = new HashMap<>();
        for (int node : nums){
            tree.put(node/10, node%10);
        }

        dfs(tree, nums[0]/10, 0, result);
        return result[0];
    }

    private void dfs(Map<Integer, Integer> tree, int node, int sum, int[] result){
        final int value = tree.get(node);
        sum+=value;
        final int pos = node % 10;
        final int level = node/10;

        int left = (level+1)*10 + (pos-1)*2 + 1;
        int right = (level+1)*10 +(pos-1)*2 + 2;
        if (!tree.containsKey(left) && !tree.containsKey(right)){
            result[0]+=sum;
            return;
        }
        if (tree.containsKey(left)){
            dfs(tree, left, sum, result);
        }
        if (tree.containsKey(right)){
            dfs(tree, right, sum, result);
        }
    }

    public static void main(String[] args) {
        int[] in1 = {113, 215, 221};
        System.out.println(new Solution().pathSum(in1)+" (13)");

        int[] in2 = {113, 221};
        System.out.println(new Solution().pathSum(in2)+" (4)");

        int[] in3 = {};
        System.out.println(new Solution().pathSum(in3));
    }
}
