package sorting.heap;

/**
 * https://leetcode.com/problems/sort-an-array/description/
 */
public class SortAnArray {
    public int[] sortArray(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            heapify(nums, nums.length, i);
        }

        for (int i = nums.length - 1; i > 0; i--) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            heapify(nums, i, 0);
        }
        return nums;
    }

    public void heapify(int[] arr, int heapSize, int index) {
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
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            heapify(arr, heapSize, largest);
        }
    }
}
