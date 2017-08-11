package n637.average.of.levels.in.binary.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>637. Average of Levels in Binary Tree</p>
 * <p>Difficulty:Easy</p>
 * <p>Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

 <p>Example 1:
 <pre>
 Input:
       3
      / \
     9  20
       /  \
      15   7
 Output: [3, 14.5, 11]
 Explanation:
 The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].</pre></p>
 <p>Note:
 The range of node's value is in the range of 32-bit signed integer.</p>
 */
public class Solution {
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> result = new ArrayList<>();
		ArrayDeque<TreeNode> queue = new ArrayDeque<>();
		TreeNode endOfLevelFlag = new TreeNode(0);
		queue.addLast(root);
		queue.addLast(endOfLevelFlag);
		double sum = 0, count = 0;
		while (!queue.isEmpty()){
			TreeNode n = queue.removeFirst();
			if (n==endOfLevelFlag) {
				if (!queue.isEmpty()){
					queue.addLast(endOfLevelFlag);
				}
				result.add(sum/count);
				sum = 0;
				count = 0;
			} else {
				sum+=n.val;
				count++;
				if (n.left!=null){
					queue.addLast(n.left);
				}
				if (n.right!=null){
					queue.addLast(n.right);
				}
			}
		}
		return result;
	}
}
