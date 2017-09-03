package n669.trim.a.binary.search.tree.Solution;

/**
 * <p>669. Trim a Binary Search Tree</p>
 * <p>Difficulty: Easy</p>
 * <p>Given a binary search tree and the lowest and highest boundaries as L and R,
 * trim the tree so that all its elements lies in [L, R] (R >= L).
 * You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.</p>

 <p>Example 1:
 <pre>Input:
   1
  / \
 0   2

 L = 1
 R = 2

 Output:
 1
  \
   2
 </pre></p>
 <p>Example 2:
 <pre>Input:
     3
    / \
   0   4
   \
   2
  /
 1

 L = 1
 R = 3

 Output:
     3
    /
   2
  /
 1
 </pre></p>
 */
public class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root==null){
            return null;
        }
        if (root.val<L){
            return trimBST(root.right, L, R);
        } else if (root.val>R) {
            return trimBST(root.left, L, R);
        } else {
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        System.out.println(new Solution().trimBST(root1, 1,2));

        TreeNode root2 = new TreeNode(1, new TreeNode(0), new TreeNode(2));
        System.out.println(new Solution().trimBST(root2, 1,2));

        TreeNode root3 = new TreeNode(3, new TreeNode(0, null, new TreeNode(2, new TreeNode(1), null)), new TreeNode(4));
        System.out.println(new Solution().trimBST(root3, 1,3));
    }
}
