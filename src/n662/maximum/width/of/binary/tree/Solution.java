package n662.maximum.width.of.binary.tree;

import java.util.ArrayDeque;

/**
 * <p>662. Maximum Width of Binary Tree</p>
 * <p>Difficulty: Medium</p>
 * <p>Given a binary tree, write a function to get the maximum width of the given tree. 
 * The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.</p>
 * <p>The width of one level is defined as the length between the end-nodes 
 * (the leftmost and right most non-null nodes in the level, where the null 
 * nodes between the end-nodes are also counted into the length calculation.</p>

<p>Example 1:
<pre>
Input: 

           1
         /   \
        3     2
       / \     \  
      5   3     9 

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
</pre></p>
<p>Example 2:
<pre>Input: 

          1
         /  
        3    
       / \       
      5   3     

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).</pre></p>
<p>Example 3:
<pre>Input: 

          1
         / \
        3   2 
       /        
      5      

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).</pre></p>
<p>Example 4:
<pre>Input: 

          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).</pre></p>


<p>Note: Answer will in the range of 32-bit signed integer.</p>

 *
 */
public class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        final TreeNode NULL = new TreeNode(0);
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root==null?NULL:root);
        boolean empty = root==null;
        int max = root==null?0:1;
        while (!empty){
            int first = -1, last = -1;
            ArrayDeque<TreeNode> next = new ArrayDeque<>();            
            while (!queue.isEmpty()) {
                TreeNode n = queue.removeFirst();
                if (n==NULL){
                    if (first>=0) next.addLast(NULL);
                    if (first>=0) next.addLast(NULL);
                } else {
                    for (TreeNode p: new TreeNode[]{n.left, n.right}){
                        if (p!=null){
                            if (first==-1){
                                first = next.size();
                            }
                            next.addLast(p);
                            last = next.size();                            
                        } else {
                            if (first>=0) next.addLast(NULL);
                        }
                    }
                }
            }
            max = Math.max(max, last-first);
            empty = (first==last);
            if (last>0){
                while (next.size()>last ){
                    next.removeLast();
                }
            }
            queue = next;
        }        
        return max;
    }
}
