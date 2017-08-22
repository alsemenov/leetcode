package n236.lowest.common.ancestor.of.a.binary.tree;

/**
 * <p>236. Lowest Common Ancestor of a Binary Tree</p>
 * <p>Difficulty:Medium</p>
 * <p>Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.</p>
 * <p>According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between
 * two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow
 * a node to be a descendant of itself).”</p>
<p><pre>
        _______3______
       /              \
   ___5__          ___1__
  /      \        /      \
 6      _2       0       8
      /  \
     7   4
 </pre></p>
 <p>For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5,
 since a node can be a descendant of itself according to the LCA definition.</p>
 */
class Solution {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		return dfs(root, p, q).lca;
	}

	private static class LCA {
		TreeNode lca = null;
		boolean p = false;
		boolean q = false;

		LCA merge(LCA other, TreeNode root){
			if (this.lca==null){
				this.lca = other.lca;
			}
			this.p = this.p || other.p;
			this.q = this.q || other.q;
			if (this.lca==null && p && q){
				this.lca = root;
			}
			return this;
		}
	}

	private LCA dfs(TreeNode root, TreeNode p, TreeNode q){
		LCA result = new LCA();
		if (root==null) {
			return result;
		}
		result.p = root==p;
		result.q = root==q;
		if (root.left!=null) {
			result.merge(dfs(root.left, p, q), root);
		}
		if (result.lca==null && root.right!=null) {
			result.merge(dfs(root.right, p, q), root);
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3,
				new TreeNode(5,
						new TreeNode(6),
						new TreeNode(2,
								new TreeNode(7),
								new TreeNode(4)
						)
		        ),
				new TreeNode(1,
						new TreeNode(0),
						new TreeNode(8)
				)
		);
		System.out.println(new Solution().lowestCommonAncestor(root, root.left.right.right, root.left).val);
	}
}
