package sorting.bucket;

import java.util.*;

/**
 * Bucket Sort implementation.
 * This algorithm distributes elements into a number of buckets, sorts each bucket individually,
 * and then concatenates the sorted buckets to produce the final sorted array.
 */

public class Main {

    public static void main(String[] args) {
        int[] data = {42, 32, 33, 52, 37, 47, 51};
        bucketSort(data, 5);
        System.out.println(Arrays.toString(data));
    }

    public static void bucketSort(int[] arr, int K) {
        List<List<Integer>> buckets = new ArrayList<>(K);
        for (int i = 0; i < K; i++) {
            buckets.add(new ArrayList<>());
        }
        int shift = Arrays.stream(arr).min().getAsInt();
        int maxValue = Arrays.stream(arr).max().getAsInt() - shift;
        // place elements into buckets
        double bucketSize = (double) maxValue / K;
        if (bucketSize < 1) {
            bucketSize = 1.0;
        }
        for (int elem : arr) {
            // same as K * arr[i] / max(lst)
            int index = (int) ((elem - shift) / bucketSize);
            if (index == K) {
                // put the max value in the last bucket
                buckets.get(K - 1).add(elem);
            } else {
                buckets.get(index).add(elem);
            }
        }

        // sort individual buckets
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // convert sorted buckets into final output
        List<Integer> sortedList = new ArrayList<Integer>();
        for (List<Integer> bucket : buckets) {
            sortedList.addAll(bucket);
        }

        // perfectly fine to just return sortedList here
        // but common practice is to mutate original array with sorted elements
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sortedList.get(i);
        }
    }

}
