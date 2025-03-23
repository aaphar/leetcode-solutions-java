package linkedList;

/**
 * https://leetcode.com/problems/add-two-numbers/description/
 */

class ListNode {
    int val;
    ListNodeN next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNodeN next) {
        this.val = val;
        this.next = next;
    }
}

public class AddTwoNumbers {

//    Time complexity : O(max(m,n)). Assume that m and n represents the length of l1 and l2 respectively.
//    Space complexity : O(1). The length of the new list is at most max(m,n)+1 However, we don't count the answer as part of the space complexity.

    public ListNodeN addTwoNumbers(ListNodeN l1, ListNodeN l2) {
        ListNodeN headNode = new ListNodeN(0);
        ListNodeN result = headNode;
        int carry = 0;

        while (l2 != null || l1 != null || carry != 0) {
            int num1 = 0;
            int num2 = 0;
            if (l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }
            int sum = carry + num1 + num2;
            carry = sum / 10;
            result.next = new ListNodeN(sum % 10);
            result = result.next;
        }
        return headNode.next;
    }

    /**
     * Input: l1 = [2,4,3], l2 = [5,6,4]
     * Output: [7,0,8]
     * Explanation: 342 + 465 = 807.
     */
}
