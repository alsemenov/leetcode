package n652.find.duplicate.subtrees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * <p>652. Find Duplicate Subtrees
 * <p>Difficulty: Medium
 * <p>Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 * <p>Two trees are duplicate if they have the same structure with same node values.
 * <p>Example 1:
 * <pre> 
        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
</pre>      
The following are two duplicate subtrees:
<pre>
      2
     /
    4
</pre>    
and
<pre>
    4
</pre>    
Therefore, you need to return above trees' root in the form of a list.
 * 
 */
	public class Solution {
	    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {        
	        
	        Comparator<TreeNode> cmp = new Comparator<TreeNode>(){
	            public int compare(TreeNode n1, TreeNode n2){
	                if (n1==null && n2==null){
	                    return 0;
	                }
	                if (n1!=null && n2==null){
	                    return 1;
	                }
	                if (n1==null && n2!=null){
	                    return -1;
	                }
	                int res = Integer.compare(n1.val, n2.val);
	                if (res!=0){
	                    return res;
	                }
	                res = compare(n1.left, n2.left);
	                if (res!=0){
	                    return res;
	                }
	                return compare(n1.right, n2.right);
	            }          
	        };
	        
	        TreeSet<TreeNode> visited = new TreeSet<>(cmp);
	        TreeSet<TreeNode> result = new TreeSet<>(cmp);
	        List<TreeNode> stack = new ArrayList<>();
	        if (root!=null) { 
	        	stack.add(root); 
	        }
	        while (!stack.isEmpty()){
	            TreeNode n = stack.remove(stack.size()-1);
	            if (!visited.add(n)){
	                result.add(n);
	            }
	            
	            if (n.left!=null){
	                stack.add(n.left);
	            }
	            if (n.right!=null){
	                stack.add(n.right);
	            }
	        }
	        return new ArrayList<TreeNode>(result);
	    }   
	}
