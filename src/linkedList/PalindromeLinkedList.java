package linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-linked-list/description
 */
public class PalindromeLinkedList {

    public boolean isPalindromeB(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse slow
        reverseList(slow);

        while (slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;

    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;    //step1
            curr.next = prev;              //step2
            prev = curr;                //step3
            curr = next;                   //step4
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return isListPalindrome(list);
    }

    public boolean isListPalindrome(List<Integer> list) {
        int start = 0, end = list.size() - 1;

        while (start != end && start < list.size() && end >= 0) {
            if (list.get(start) != list.get(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
