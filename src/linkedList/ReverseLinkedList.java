package linkedList;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {
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
}

/**
 * /explanationWithImages/ReverseLinkedList.gif
 */
