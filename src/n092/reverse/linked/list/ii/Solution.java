package n092.reverse.linked.list.ii;

/**
 * <p>92. Reverse Linked List II</p>
 * <p>Difficulty:Medium</p>
 * <p>Reverse a linked list from position m to n. Do it in-place and in one-pass.</p>

 <p>For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.</p>

 <p>Note:
 Given m, n satisfy the following condition:
 1 ? m ? n ? length of list.</p>
 */
public class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		// create additional head node to simplify head changes
		ListNode h = new ListNode(0);
		h.next = head;
		// find node prior m, store it into pm
		int i;
		ListNode pm, nn, r = null, x;
		for (x=h, i=1; i<m; i++){
			x = x.next;
		}
		nn = pm = x;
		// reverse nodes starting from m
		x = x.next;
		while (i<=n){
			ListNode z = x.next;
			x.next = r;
			if (r==null){
				nn = x; // remember last node in reversed chain
			}
			r = x;
			x = z;
			i++;
		}
		pm.next = r;
		nn.next = x;
		return h.next;
	}
}

