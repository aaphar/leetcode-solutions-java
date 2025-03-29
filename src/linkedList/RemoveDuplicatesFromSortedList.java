package linkedList;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head != null) {
            ListNode next = head.next;
            if (next != null && next.val == head.val) {
                head.next = next.next;
                deleteDuplicates(head);
            } else {
                deleteDuplicates(head.next);
            }
        }
        return head;
    }
}
