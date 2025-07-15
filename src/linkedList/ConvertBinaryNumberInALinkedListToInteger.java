package linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 */
public class ConvertBinaryNumberInALinkedListToInteger {
    public int getDecimalValue(ListNode head) {
        List<Integer> list = new ArrayList();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int number = 0;
        int length = list.size();
        for (int i = length - 1; i >= 0; i--) {
            if (list.get(i) == 1) {
                number += (int) Math.pow(2, length - i - 1);
            }
        }
        return number;
    }
}
