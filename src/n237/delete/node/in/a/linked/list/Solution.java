package n237.delete.node.in.a.linked.list;
/**
 * <p>237. Delete Node in a Linked List
 * <p><a href="https://leetcode.com/problems/delete-node-in-a-linked-list/">https://leetcode.com/problems/delete-node-in-a-linked-list/</a>
 * <p>Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * <p>Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
 *
 */
public class Solution {
	/**
	 * copy value from next element and delete the next element
	 */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
