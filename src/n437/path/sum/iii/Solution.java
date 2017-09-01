package n437.path.sum.iii;

/**
 * <p>437. Path Sum III</p>
 * <p>Difficulty:Easy</p>
 * <p>You are given a binary tree in which each node contains an integer value.</p>

 <p>Find the number of paths that sum to a given value.</p>

 <p>The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).</p>

 <p>The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.</p>

 <p>Example:
<pre>
 root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

       10
      /  \
     5   -3
    / \    \
   3   2   11
  / \   \
 3  -2   1

 Return 3. The paths that sum to 8 are:

 1.  5 -> 3
 2.  5 -> 2 -> 1
 3. -3 -> 11</p>
 </pre>
 */
public class Solution {
	public int pathSum(TreeNode root, int sum) {
		return pathSum(root, sum, false);
	}

	public int pathSum(TreeNode root, int sum, boolean started) {
		if (root==null){
			return 0;
		}

		int result = 0;
		if (!started) {
			result += pathSum(root.left, sum, false) +
					pathSum(root.right, sum, false);
		}
		result += pathSum(root.left, sum-root.val, true) +
				pathSum(root.right, sum-root.val, true);

		if (sum==root.val) {
			result++;
		}
		return result;
	}
}
