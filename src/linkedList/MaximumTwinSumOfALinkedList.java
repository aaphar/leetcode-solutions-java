package linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description
 */
public class MaximumTwinSumOfALinkedList {

    public static int pairSumB(ListNode head) {
        if (head == null) return 0;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverseList(slow);
        int max = 0;
        fast = head;
        while (fast != null && slow != null) {
            max = Math.max(max, slow.val + fast.val);
            fast = fast.next;
            slow = slow.next;
        }
        return max;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public int pairSum(ListNode head) {
        // n-1-i => i
        // i< (n/2)-1

        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        int max = Integer.MIN_VALUE;
        int n = list.size();
        int i = 0;
        while (i < (n / 2) - 1) {
            max = Math.max(list.get(i), list.get(n - 1 - i));
            i++;
        }
        return max;

    }
}
