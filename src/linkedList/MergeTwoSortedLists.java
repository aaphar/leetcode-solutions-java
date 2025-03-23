package linkedList;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists
 */
class ListNodeNode {
    int val;
    ListNodeNode next;

    ListNodeNode() {
    }

    ListNodeNode(int val) {
        this.val = val;
    }

    ListNodeNode(int val, ListNodeNode next) {
        this.val = val;
        this.next = next;
    }
}

// Time complexity: O(n + m)
// Space complexity: O(1)
public class MergeTwoSortedLists {
    public ListNodeNode mergeTwoLists(ListNodeNode list1, ListNodeNode list2) {
        ListNodeNode head = new ListNodeNode();
        ListNodeNode current = head;

        while (list1 != null || list2 != null) {
            int val1 = list1 != null ? list1.val : Integer.MAX_VALUE;
            int val2 = list2 != null ? list2.val : Integer.MAX_VALUE;
            current.next = new ListNodeNode();
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
