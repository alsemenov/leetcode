package n617.merge.two.binary.trees;

/**
 * <p>617. Merge Two Binary Trees</p>
 * <p>Difficulty:Easy</p>
 * <p>Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two
 * trees are overlapped while the others are not.</p>
 * <p>You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values
 * up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.</p>

 <p>Example 1:
 <pre>
 Input:
    Tree 1                    Tree 2
      1                         2
     / \                       / \
    3   2                     1   3
   /                           \   \
 5                             4   7
 Output:
 Merged tree:
     3
    / \
   4   5
  / \   \
 5   4   7
 </pre></p>
 <p>Note: The merging process must start from the root nodes of both trees.</p>
 */
public class Solution {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1==null && t2==null){
			return null;
		}
		if (t1!=null && t2!=null){
			TreeNode t = new TreeNode(t1.val+t2.val);
			t.left = mergeTrees(t1.left, t2.left);
			t.right = mergeTrees(t1.right, t2.right);
			return t;
		}
		return t1==null? t2 : t1;
	}
}
