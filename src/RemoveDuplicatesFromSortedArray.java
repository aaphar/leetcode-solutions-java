/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int length=1;

        for(int i=1; i<nums.length; i++){
            if (nums[i] != nums[i - 1])
            {
                nums[length] = nums[i];
                length++;
            }
        }
        return length;
    }
}
