package n235.lowest.common.ancestor.of.a.binary.search.tree;

/**
 * <p>235. Lowest Common Ancestor of a Binary Search Tree</p>
 * <p>Difficulty:Easy</p>
 * <p>Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.</p>
 * <p>According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”</p>
 * <pre>
 *             _______6______
              /              \
          ___2__          ___8__
         /      \        /      \
        0      _4       7       9
      /  \
     3   5
 * </pre>
 * <p>For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.</p>

 */
public class Solution {
	/**
	 * Solution with recursion
	 */
	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		if (root==p || root==q){
			return root;
		}
		TreeNode np = (p.val<root.val) ? root.left : root.right;
		TreeNode nq = (q.val<root.val) ? root.left : root.right;
		if (np!=nq) {
			return root;
		}
		return lowestCommonAncestor1(np, p, q);
	}

	/**
	 * Solution without recursion
	 */
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode n = root, np = root, nq = root;
		do {
			n = np;
			np = (p.val<n.val) ? n.left : n.right;
			nq = (q.val<n.val) ? n.left : n.right;
		} while (np==nq && n!=q && n!=p);
		return n;
	}
}
