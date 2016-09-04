package n111.minimum.depth.of.binary.tree;

import java.util.ArrayDeque;
import java.util.Deque;
/**
 * <p>111. Minimum Depth of Binary Tree
 * <p><a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/">https://leetcode.com/problems/minimum-depth-of-binary-tree/</a>
 * <p>Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * 
 */
public class Solution {
	/**
	 * use breadth first search to find first leaf node.
	 */
    public int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.addLast(root);
        int minDepth = 0;
        while (!queue.isEmpty()){
            minDepth++;
            for(int i=queue.size(); i>0; i--){
                TreeNode n = queue.pollFirst();
                if (n.left==null && n.right==null){
                    return minDepth;
                }
                if (n.left!=null) {
                    queue.addLast(n.left);
                }
                if (n.right!=null){
                    queue.addLast(n.right);
                }
            }
        }
        return minDepth;
    }
}
