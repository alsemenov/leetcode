package n100.same.tree;

import java.util.ArrayDeque;

/**
<p>100. Same Tree
<p>Difficulty: Easy
<p>Given two binary trees, write a function to check if they are equal or not.

<p>Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 *
 */
public class Solution {
    
	public boolean isSameTree(TreeNode p, TreeNode q) {
        return ((p!=null && q!=null && p.val==q.val &&
                    isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
                    || (p==null && q==null));
    }
    
    /**
     * BFS based solution, should be used for trees with large height
     */
    public boolean isSameTreeBFS(TreeNode p, TreeNode q) {
        
        ArrayDeque<TreeNode> pQueue = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> qQueue = new ArrayDeque<TreeNode>();
        if (p!=null && q!=null){
            pQueue.addLast(p);
            qQueue.addLast(q);
        } else {
            return p==q; // either p or q is null, check that the other is also null
        }
        
        while (!pQueue.isEmpty()){
            TreeNode p1 = pQueue.pollFirst();
            TreeNode q1 = qQueue.pollFirst();
            if (p1.val!=q1.val || 
                ((p1.left==null) ^ (q1.left==null))
                || ((p1.right==null) ^ (q1.right==null))){
                return false;
            }
            if (p1.left!=null){
                pQueue.addLast(p1.left);
                qQueue.addLast(q1.left);
            }
            if (p1.right!=null){
                pQueue.addLast(p1.right);
                qQueue.addLast(q1.right);
            }
        }
        return true;
    }
}
