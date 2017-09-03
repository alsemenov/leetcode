package n671.second.minimum.node.in.a.binary.tree;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>671. Second Minimum Node In a Binary Tree</p>
 * <p>Difficulty: Easy</p>
 * <p>Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node
 * in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is
 * the smaller value among its two sub-nodes.</p>

 <p>Given such a binary tree, you need to output the second minimum value in the set made of all
 the nodes' value in the whole tree.</p>

 <p>If no such second minimum value exists, output -1 instead.</p>

 <p>Example 1:
 <pre>
 Input:
   2
  / \
 2   5
    / \
   5   7

 Output: 5
 Explanation: The smallest value is 2, the second smallest value is 5.</pre></p>
 <p>Example 2:
 <pre>Input:
   2
  / \
 2   2

 Output: -1
 Explanation: The smallest value is 2, but there isn't any second smallest value.</pre></p>
 */
public class Solution {

    private TreeNode removeRoot(TreeNode root){
        if (root==null) {
            return null;
        }
        if (root.left==null){
            return root.right;
        }
        if (root.right==null){
            return root.left;
        }
        TreeNode newRoot = new TreeNode(0);
        if (root.left.val<root.right.val) {
            newRoot.val = root.left.val;
            newRoot.left = removeRoot(root.left);
            newRoot.right = root.right;
        } else {
            newRoot.val = root.right.val;
            newRoot.left = root.left;
            newRoot.right = removeRoot(root.right);
        }
        return newRoot;
    }

    /**
     * think of tree as a min heap, so need to remove root element and consider next root element
     */
    public int findSecondMinimumValue1(TreeNode root) {
        int min1 = root.val;
        while ((root = removeRoot(root))!=null && root.val==min1);
        return root==null? -1 : root.val;
    }

    /**
     * Use BFS with priority queue to find next minimum
     * @param root
     * @return
     */
    public int findSecondMinimumValue(TreeNode root) {
        if (root==null){
            return -1;
        }
        PriorityQueue<TreeNode> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
        pq.add(root);
        int min = root.val;
        while (!pq.isEmpty()){
            TreeNode n = pq.poll();
            if (n.val!=min){
                return n.val;
            }
            if (n.left!=null) {
                pq.add(n.left);
            }
            if (n.right!=null){
                pq.add(n.right);
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(10);
        System.out.println(new Solution().findSecondMinimumValue(root1));

        TreeNode root2 = new TreeNode(10, new TreeNode(20), null);
        System.out.println(new Solution().findSecondMinimumValue(root2));

        TreeNode root3 = new TreeNode(10, new TreeNode(10), new TreeNode(10));
        System.out.println(new Solution().findSecondMinimumValue(root3));

        TreeNode root4 = new TreeNode(2, new TreeNode(2), new TreeNode(5, new TreeNode(5), new TreeNode(7)));
        System.out.println(new Solution().findSecondMinimumValue(root4));

        TreeNode root5 = new TreeNode(2,
                                new TreeNode(2,
                                        new TreeNode(6),
                                        new TreeNode(5)
                                ),
                                new TreeNode(2,
                                        new TreeNode(4),
                                        new TreeNode(3)
                                )
        );
        System.out.println(new Solution().findSecondMinimumValue(root5));
    }
}
