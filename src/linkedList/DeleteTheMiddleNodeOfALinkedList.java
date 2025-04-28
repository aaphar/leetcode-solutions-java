package linkedList;

/**
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/
 */
public class DeleteTheMiddleNodeOfALinkedList {

    public static ListNode deleteMiddleB(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        int l = getLength(head);

        int middle = l / 2;
        ListNode prev = null;
        ListNode curr = head;

        while (middle != 0) {
            prev = curr;
            curr = curr.next;
            middle--;
        }

        prev.next = curr.next;

        return head;

    }

    public int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }

        return getLength(head.next) + 1;
    }
}
