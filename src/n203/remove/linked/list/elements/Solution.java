package n203.remove.linked.list.elements;
/**
 * <p>203. Remove Linked List Elements
 * <p><a href="https://leetcode.com/problems/remove-linked-list-elements/">https://leetcode.com/problems/remove-linked-list-elements/</a>
 * <p>Remove all elements from a linked list of integers that have value val.
 * <p>Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 *
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head!=null && head.val==val){
            head = head.next;
        }
        if (head!=null){
            ListNode n = head.next;
            ListNode p = head;
            while (n!=null){
                if (n.val==val){
                    p.next = n.next;
                } else {
                    p = n;
                }
                n = n.next;
            }
        }
        return head;
    }
}
