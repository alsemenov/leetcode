package n226.invert.binary.tree;
/**
 * <p>226. Invert Binary Tree
 * <p><a href="https://leetcode.com/problems/invert-binary-tree/">https://leetcode.com/problems/invert-binary-tree/</a>
 * <p>Invert a binary tree.
<pre>
     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
</pre>
 *
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return root;
        }
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
