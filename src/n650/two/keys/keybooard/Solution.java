package n650.two.keys.keybooard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>650. 2 Keys Keyboard</p>
 * <p>Difficulty:Medium</p>
 * <p>Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:<ol>

 <li>Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).</li>
 <li>Paste: You can paste the characters which are copied last time.</ol></li>
 Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.</p>
 <p><b>Example 1:</b>
 <pre>
 Input: 3
 Output: 3
 Explanation:
 Intitally, we have one character 'A'.
 In step 1, we use Copy All operation.
 In step 2, we use Paste operation to get 'AA'.
 In step 3, we use Paste operation to get 'AAA'.</pre>
 <b>Note:</b>
 The n will be in the range [1, 1000].</p>
 */
public class Solution {
	public int minSteps1(int n) {
		// DP solution
		int[] min = new int[n + 1];
		Arrays.fill(min, Integer.MAX_VALUE);
		min[1] = 0;

		for (int i = 1; i <= n; i++) {
			// min[i] - number of steps to achieve i 'A'
			for (int k = 2; i * k <= n; k++) {
				int z = i * k; // new achieved number of 'A'
				min[z] = Math.min(min[z], min[i] + k);
			}
		}
		return min[n];
	}

	public int minSteps2(int n) {
		// The solution is using BFS algorithm
		// node is an array of three integers:
		//  1. number of steps to reach the node
		//  2. number of 'A' in notepad
		//  3. number of 'A' in clipboard
		// from each node it is possible either paste again or copy-paste
		// which lead to two new nodes.
		// The queue is a priority queue, which allows us to consider nodes with minimal number of steps first.
		Comparator<int[]> cmp = Comparator.<int[]>comparingInt(o->o[0]);
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(cmp);
		queue.add(new int[]{0,1,0});
		queue.add(new int[]{2,2,1});
		while (!queue.isEmpty()) {
			final int[] node = queue.poll();
			if (node[1]==n){
				return node[0];
			}
			// paste
			final int[] pasteNode = new int[]{node[0]+1, node[1]+node[2], node[2]};
			if (node[2]!=0 && pasteNode[1]<=n) {
				queue.add(pasteNode);
			}
			// copyPaste
			final int[] copyPasteNode = new int[]{node[0]+2, node[1]+node[1], node[1]};
			if (copyPasteNode[1]<=n) {
				queue.add(copyPasteNode);
			}
		}
		throw new RuntimeException("solution is not found");
	}
}
