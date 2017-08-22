package n236.lowest.common.ancestor.of.a.binary.tree;

/**
 * Created by semenov on 19.07.2017.
 */
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
