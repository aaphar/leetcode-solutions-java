package august;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-69-number/description/
 */
public class Maximum69Number {

    public static int maximum69Number(int num) {
        List<Integer> list = new ArrayList<>();

        while (num > 0) {
            list.add(num % 10);
            num /= 10;
        }
        int newNum = 0;
        boolean changed = false;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) == 6 && !changed) {
                list.add(i, 9);
                changed = true;
            }
            newNum = newNum * 10 + list.get(i);
        }

        return newNum;
    }

}
