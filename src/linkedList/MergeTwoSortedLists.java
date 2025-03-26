package linkedList;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists
 */

// Time complexity: O(n + m)
// Space complexity: O(1)
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode current = head;

        while (list1 != null || list2 != null) {
            int val1 = list1 != null ? list1.val : Integer.MAX_VALUE;
            int val2 = list2 != null ? list2.val : Integer.MAX_VALUE;
            current.next = new ListNode();
            current = current.next;
            if (val2 > val1) {
                current.val = val1;
                list1 = list1.next;
            } else {
                current.val = val2;
                list2 = list2 != null ? list2.next : null;
            }
        }
        return head;
    }


}
