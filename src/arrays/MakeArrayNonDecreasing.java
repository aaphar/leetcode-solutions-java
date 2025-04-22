package arrays;

/**
 * https://leetcode.com/problems/make-array-non-decreasing/description/
 */
public class MakeArrayNonDecreasing {
    public int maximumPossibleSize(int[] nums) {
        int count=nums.length;
        int j=0;
        for(int i=1; i<nums.length; i++){
            if (nums[i] < nums[j]) {
                nums[i]=nums[j];
                count--;
            }
            j++;
        }
        return count;
    }
}
