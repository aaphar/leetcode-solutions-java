package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/description/?envType=problem-list-v2&envId=2lhxgujc
 */
public class PascalsTriangle2 {


    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();

        if (rowIndex == 0) {
            result.add(1);
            return result;
        } else {
            result.add(1);
            List<Integer> preRow = getRow(rowIndex - 1);
            for (int i = 1; i < rowIndex; i++) {
                result.add(preRow.get(i - 1) + preRow.get(i));
            }
            result.add(1);
            return result;
        }
    }
}
