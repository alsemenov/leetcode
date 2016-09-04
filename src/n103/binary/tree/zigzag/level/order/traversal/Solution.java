package n103.binary.tree.zigzag.level.order.traversal;

import java.util.ArrayList;
import java.util.List;
/**
<p>103. Binary Tree Zigzag Level Order Traversal
<p>Difficulty: Medium
<p>Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

<p>For example:
Given binary tree [3,9,20,null,null,15,7],
<pre>
    3
   / \
  9  20
    /  \
   15   7
</pre>   
return its zigzag level order traversal as:
<pre>
[
  [3],
  [20,9],
  [15,7]
]
</pre>
 *
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root==null){
            return result;
        }
        
        List<TreeNode> level = new ArrayList<TreeNode>();
        level.add(root);
        boolean inverse = false;
        while (!level.isEmpty()){
            List<Integer> intLevel = new ArrayList<Integer>(level.size());
            List<TreeNode> nextLevel = new ArrayList<TreeNode>();
            for (TreeNode n: level){
                if (n.left!=null){
                    nextLevel.add(n.left);
                }
                if (n.right!=null){
                    nextLevel.add(n.right);
                }
                if (!inverse){
                    intLevel.add(n.val);
                }
            }
            if (inverse){
                for (int k=level.size()-1; k>=0; k--){
                    intLevel.add(level.get(k).val);
                }
            }
            result.add(intLevel);
            inverse = !inverse;
            level = nextLevel;
        }
        return result;
    }
}
