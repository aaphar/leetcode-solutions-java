package binarySearch;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/snapshot-array
 */
class Main {
    public static void main(String[] args) {
        SnapshotArray snapshotArr = new SnapshotArray(1); // set the length to be 3
        snapshotArr.set(0, 4);  // Set array[0] = 5
        snapshotArr.set(0, 16);  // Set array[0] = 5
        snapshotArr.set(0, 13);  // Set array[0] = 5
        System.out.println(snapshotArr.snap()); // Take a snapshot, return snap_id = 0
        System.out.println(snapshotArr.get(0, 0));
        System.out.println(snapshotArr.snap());
    }
}

class SnapshotArray {

    Map<Integer, TreeMap<Integer, Integer>> map;
    int snap = 0;

    public SnapshotArray(int length) {
        map = new HashMap();
    }

    public void set(int index, int val) {
        TreeMap<Integer, Integer> values = map.getOrDefault(index, new TreeMap<>());
        values.put(snap, val);
        map.put(index, values);
    }

    public int snap() {
        return snap++;
    }

    public int get(int index, int snap_id) {
        TreeMap<Integer, Integer> values = map.get(index);
        if (values == null) {
            return 0;
        }
        Integer key = values.floorKey(snap_id);
        if (key != null) {
            return values.get(key);
        } else {
            return 0;
        }
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */