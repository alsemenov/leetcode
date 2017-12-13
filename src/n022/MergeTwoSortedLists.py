#Definition for singly-linked list.
class ListNode(object):
    def __init__(self, *x):
        if len(x)==0:
            self.val = None
        else:
            self.val = x[0]
        self.next = None
        n = self
        for i in range(1,len(x)):
            n.next = ListNode(x[i])
            n = n.next



class Solution(object):
    """21. Merge Two Sorted Lists

    Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
    Example:
        Input: 1->2->4, 1->3->4
        Output: 1->1->2->3->4->4
    """
    # def mergeTwoLists(self, l1, l2):
    #     """
    #     :type l1: ListNode
    #     :type l2: ListNode
    #     :rtype: ListNode
    #     """
    #     result = ListNode(0)
    #     r = result
    #     while l1 is not None or l2 is not None:
    #         if (l1 is None):
    #             value = l2.val
    #             l2 = l2.next
    #         elif l2 is None or l1.val<l2.val:
    #             value = l1.val
    #             l1 = l1.next
    #         else:
    #             value = l2.val
    #             l2 = l2.next
    #
    #         r.next = ListNode(value)
    #         r = r.next
    #
    #     return result.next

    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        result = ListNode(0)
        r = result
        while l1 is not None or l2 is not None:
            if l1 is None:
                r.next = l2
                l2 = l2.next
            elif l2 is None or l1.val<l2.val:
                r.next = l1
                l1 = l1.next
            else:
                r.next = l2
                l2 = l2.next

            r = r.next

        return result.next


def printListNode(node):
    """
    :type node: ListNode
    """
    while node is not None:
        print node.val, '->',
        node = node.next
    print None

def main():
    # printListNode(ListNode(1,2,3))
    ll1 = [None, ListNode(1), None,         ListNode(3), ListNode(1,2,4)]
    ll2 = [None, None,        ListNode(2),  ListNode(4), ListNode(1,3,4)]
    for l1,l2 in zip(ll1, ll2):
        printListNode(Solution().mergeTwoLists(l1,l2))

# This is the standard boilerplate that calls the main() function.
if __name__ == '__main__':
  main()