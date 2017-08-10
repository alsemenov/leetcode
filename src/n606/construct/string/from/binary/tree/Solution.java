package n606.construct.string.from.binary.tree;

/**
 * <p>606. Construct String from Binary Tree</p>
 * <p>Difficulty:Easy</p>
 * <p>You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.</p>
 * <p>The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty
 * parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.</p>

 <p>Example 1:
 <pre>
 Input: Binary tree: [1,2,3,4]
      1
    /   \
   2     3
  /
 4

 Output: "1(2(4))(3)"

 Explanation: Originallay it needs to be "1(2(4)())(3()())",
 but you need to omit all the unnecessary empty parenthesis pairs.
 And it will be "1(2(4))(3)".</pre></p>
 <p>Example 2:<pre>
 Input: Binary tree: [1,2,3,null,4]
    1
  /   \
 2     3
  \
   4

 Output: "1(2()(4))(3)"

 Explanation: Almost the same as the first example,
 except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the out</pre></p>
 */
public class Solution {
	public String tree2str(TreeNode t) {
		if (t==null){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		dfs(t, sb);
		return sb.toString();
	}

	private void dfs(TreeNode t, StringBuilder sb) {
		assert t!=null;
		sb.append(t.val);
		if (t.left!=null || t.right!=null){
			sb.append('(');
			if (t.left!=null){
				dfs(t.left, sb);
			}
			sb.append(')');
			if (t.right!=null){
				sb.append('(');
				dfs(t.right, sb);
				sb.append(')');
			}
		}
	}
}
