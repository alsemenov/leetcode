package n234.palindrome.linked.list;

/**
 * <p>234. Palindrome Linked List</p>
 * <p>Difficulty:Easy</p>
 * <p>Given a singly linked list, determine if it is a palindrome.</p>
 * <p><b>Follow up:</b>Could you do it in O(n) time and O(1) space?</p>
 */
public class Solution {
	public boolean isPalindrome(ListNode head) {
		// find node in the middle and reverse head
		ListNode n = head, p = head, r = null;
		while (n!=null && n.next!=null) {
			n = n.next.next;
			ListNode z = p.next;
			p.next = r;
			r = p;
			p = z;
		}
		if (n!=null){
			p = p.next;
		}
		// compare r and p
		while(p!=null && p.val==r.val){
			p = p.next;
			r = r.next;
		}
		return p==null;
	}

	public static void main(String[] args) {
		final Solution solution = new Solution();
		ListNode n = null;
		System.out.println("null: "+solution.isPalindrome(null));
		System.out.println("1: "+solution.isPalindrome(new ListNode(1)));
		System.out.println("1->2: "+solution.isPalindrome(new ListNode(1, new ListNode(2))));
		System.out.println("1->1: "+solution.isPalindrome(new ListNode(1, new ListNode(1))));
		System.out.println("1->2->1: "+solution.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(1)))));
		System.out.println("1->2->2: "+solution.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2)))));
		System.out.println("1->2->2->1: "+solution.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))));
	}
}
