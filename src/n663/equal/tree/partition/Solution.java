package n663.equal.tree.partition;
/**
 * <p>663. Equal Tree Partition</p>
 * <p>Difficulty: Medium</p>
 * <p>Given a binary tree with n nodes, your task is to check if it's possible to partition the tree to two trees 
 * which have the equal sum of values after removing exactly one edge on the original tree.</p>
 * <p>Example 1:
<pre>Input:     
    5
   / \
  10 10
    /  \
   2   3

Output: True
Explanation: 
    5
   / 
  10
      
Sum: 15

   10
  /  \
 2    3

Sum: 15</pre></p>
<p>Example 2:
<pre>Input:     
    1
   / \
  2  10
    /  \
   2   20

Output: False
Explanation: You can't split the tree into two trees with equal sum after removing exactly one edge on the tree.</pre></p>
<p>Note:<ol>
<li>The range of tree node value is in the range of [-100000, 100000].</li>
<li>1 <= n <= 10000</li></ol></p>
 *
 */
public class Solution {
    public boolean checkEqualTree(TreeNode root) {
        if (root==null || (root.left==null && root.right==null)){
            return false;
        }
        int sum = sumValues(root);
        boolean[] result = new boolean[1];
        result[0] = false;
        dfs(root, sum, result);        
        return result[0];
    }
    
    private int sumValues(TreeNode root){
        if (root==null){
            return 0;
        }
        return root.val+sumValues(root.left)+sumValues(root.right);        
    }
    
    private int dfs(TreeNode root, int sum, boolean[] result){
        if (root==null || result[0]){
            return 0;
        }
        int leftSum = dfs(root.left, sum, result);
        int rightSum = dfs(root.right, sum, result);
        if (leftSum==sum-leftSum || rightSum==sum-rightSum){
            result[0] = true;
        }
        return root.val + leftSum + rightSum;
    }
}
