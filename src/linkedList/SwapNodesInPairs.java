package linkedList;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        //1,2,3,4
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(swapPairs(head));
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }

        if (head.next == null) {
            return head;
        }

        ListNode res = head;

        ListNode next = res.next;
        if (next != null) {
            res.next = next.next;
            next.next = res;
        }
        res = next;

        if (res != null && res.next != null) {
            ListNode sN = swapPairs(res.next.next);
            res.next.next = sN;
        }
        return res;
    }
}
