package n199.binary.tree.right.side.view;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>199. Binary Tree Right Side View</p>
 * <p>Difficulty:Medium</p>
 * <p>Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.</p>

<p>For example:
<pre>Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
</pre></p>
 *
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if (root!=null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            ArrayDeque<TreeNode> next = new ArrayDeque<>();
            while (!queue.isEmpty()){
                TreeNode n = queue.removeFirst();
                if (n.left!=null){
                    next.addLast(n.left);
                }
                if (n.right!=null){
                    next.addLast(n.right);
                }
                if (queue.isEmpty()){
                    result.add(n.val);
                }
            }
            queue = next;
        }
        return result;
    }
}
