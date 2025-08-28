package linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/description
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNodeB(ListNode headA, ListNode headB) {
        ListNode dummyA = headA;
        ListNode dummyB = headB;
        while (dummyA != dummyB) {

            dummyA = (dummyA == null) ? headB : dummyA.next;

            dummyB = (dummyB == null) ? headA : dummyB.next;
        }
        if (dummyA == dummyB) {
            return dummyA;
        }

        return new ListNode();
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode res = new ListNode();
        ListNode result = res;
        ListNode dummyA = headA;
        ListNode dummyB = headB;
        while (dummyA != null) {
            map.put(dummyA, map.getOrDefault(dummyA, 0) + 1);
            dummyA = dummyA.next;
        }

        while (dummyB != null) {
            if (map.getOrDefault(dummyB, 0) > 0) {
                result.next = dummyB;
                result = result.next;
            }
            dummyB = dummyB.next;
        }

        return res.next;
    }
}
