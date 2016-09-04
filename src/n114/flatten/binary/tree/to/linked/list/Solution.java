package n114.flatten.binary.tree.to.linked.list;
/**
 * <p>114. Flatten Binary Tree to Linked List
 * <p>Given a binary tree, flatten it to a linked list in-place.
<p>
For example,
Given
<pre>
         1
        / \
       2   5
      / \   \
     3   4   6
</pre>
<p>The flattened tree should look like:
<pre>
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
</pre>

<p>Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
 *
 */
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        flatten(left);
        flatten(right);
        root.left = null;
        
        root.right = left;
        TreeNode p = null;
        while (left!=null){
            p = left;
            left = left.right;
        }
        if (p==null){
            root.right = right;
        } else {
            p.right = right;
        }
    }
}
