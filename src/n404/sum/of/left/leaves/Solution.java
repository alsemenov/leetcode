package n404.sum.of.left.leaves;

import java.util.ArrayList;

/**
 * <p>404. Sum of Left Leaves</p>
 * <p>Difficulty:Easy</p>
 * <p>Find the sum of all left leaves in a given binary tree.</p>

 <p>Example:
<pre>
   3
  / \
 9  20
   /  \
  15   7

 There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 </pre></p>
 */
public class Solution {
	public int sumOfLeftLeaves(TreeNode root) {
		 return sumOfLeftLeavesRecursive(root, false);
		 // return sumOfLeftLeavesNonRecursive(root);
	}

	private int sumOfLeftLeavesNonRecursive(TreeNode root) {
		final ArrayList<TreeNode> left = new ArrayList<>(), right=new ArrayList<>();
		if (root!=null){
			right.add(root);
		}
		int result = 0;
		while (!left.isEmpty() || !right.isEmpty()){
			final boolean isLeft = !left.isEmpty();
			TreeNode n = isLeft ? left.remove(left.size()-1) : right.remove(right.size()-1) ;
			if (isLeft && n.left==null && n.right==null){
				result+=n.val;
			}
			if (n.left!=null){
				left.add(n.left);
			}
			if (n.right!=null){
				right.add(n.right);
			}
		}
		return result;
	}

	private int sumOfLeftLeavesRecursive(TreeNode root, boolean left){
		int result = 0;
		if (root!=null){
			if (root.left==null && root.right==null && left) {
				result +=root.val;
			}
			result+=sumOfLeftLeavesRecursive(root.left, true);
			result+=sumOfLeftLeavesRecursive(root.right, false);
		}
		return result;
	}
}
