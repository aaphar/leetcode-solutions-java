package hackerRank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConferenceSchedule {

    /*
     * Complete the 'maxPresentations' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY scheduleStart
     *  2. INTEGER_ARRAY scheduleEnd
     */

    public static int maxPresentations(List<Integer> scheduleStart, List<Integer> scheduleEnd) {
        // Write your code here
        // (1, 3), (1, 2), (2, 4)
        // (1, 2), (1, 3), (2, 4)
        List<Interval> intervals = new ArrayList<>();
        for (int i = 0; i < scheduleStart.size(); i++) {
            intervals.add(new Interval(scheduleStart.get(i), scheduleEnd.get(i)));
        }
        intervals.sort(Comparator.comparingInt(i -> i.end));

        int count = 0;
        int prevEnd = Integer.MIN_VALUE;
        for (Interval interval : intervals) {
            if (interval.start >= prevEnd) {
                prevEnd = interval.end;
                count++;
            }
        }
        return count;
    }
}

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}


