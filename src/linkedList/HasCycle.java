package linkedList;

import java.util.HashSet;
import java.util.Set;

class ListNodeN {
    int val;
    ListNodeN next;

    ListNodeN(int x) {
        val = x;
        next = null;
    }
}

public class HasCycle {
    public boolean hasCycle(ListNodeN head) {
        ListNodeN fast = head;
        ListNodeN slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}

// [3,2,0,-4]