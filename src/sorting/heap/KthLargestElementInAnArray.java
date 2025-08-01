package sorting.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 */
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(nums, 4));
    }

    public static int findKthLargest(int[] nums, int k) {
        int l = nums.length;
        for (int i = l / 2 - 1; i >= 0; i--) {
            heapify(nums, l, i);
        }
        int count = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            heapify(nums, i, 0);
            count++;
            if (count == k) {
                break;
            }
        }

        return nums[l - k];
    }

    public static void heapify(int[] arr, int heapSize, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;

        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }

        if (index != largest) {
            int temp = arr[largest];
            arr[largest] = arr[index];
            arr[index] = temp;

            heapify(arr, heapSize, largest);
        }
    }
}
