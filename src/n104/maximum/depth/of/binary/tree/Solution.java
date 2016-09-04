package n104.maximum.depth.of.binary.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>104. Maximum Depth of Binary Tree
 * <p><a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">https://leetcode.com/problems/maximum-depth-of-binary-tree/</a>
 * <p>Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 * <p>Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int leftDepth = (root.left==null)?0:maxDepth(root.left);
        int rightDepth = (root.right==null)?0:maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }
    
    public int maxDepthBFS(TreeNode root) {
        if (root==null){
            return 0;
        }
        
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.addLast(root);
        int maxDepth = 0;
        while(!queue.isEmpty()){
            // pop the level
            for (int i=queue.size(); i>0; i--) {
                TreeNode n = queue.pollFirst();
                if (n.left!=null) {
                    queue.addLast(n.left);
                }
                if (n.right!=null){
                    queue.addLast(n.right);
                }
            }
            maxDepth++;
        }
        return maxDepth;
    }    
}
