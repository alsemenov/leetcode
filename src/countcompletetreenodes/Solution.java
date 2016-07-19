package countcompletetreenodes;
/**
 * <p>222. Count Complete Tree Nodes
 * <p><a href="https://leetcode.com/problems/count-complete-tree-nodes/">https://leetcode.com/problems/count-complete-tree-nodes/</a>
 * <p>Given a complete binary tree, count the number of nodes.
<p>Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 */
public class Solution {
    public int countNodes(TreeNode root) {
        return countNodes(root, -1, -1);
    }
    
    private int countNodes(TreeNode root, int leftDepth, int rightDepth){
        if (root==null){
            return 0;
        }
        if (leftDepth<0){
            leftDepth = 0;
            for (TreeNode n=root.left; n!=null; n=n.left){
                leftDepth++;
            }
        }
        if (rightDepth<0){
            rightDepth = 0;
            for(TreeNode n=root.right; n!=null; n=n.right){
                rightDepth++;
            }
        }
        if (leftDepth==rightDepth){
            // tree depth is leftDepth+1
            return (1<<(leftDepth+1))-1;
        }
        
        return countNodes(root.left, leftDepth-1, -1) + 1 + countNodes(root.right, -1, rightDepth-1);
    }
    
    public static void main(String[] args){
    	TreeNode root = new TreeNode(1, new TreeNode(2), null);
    	System.out.println(new Solution().countNodes(root));
    }
}
