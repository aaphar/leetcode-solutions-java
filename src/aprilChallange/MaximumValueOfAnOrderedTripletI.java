package aprilChallange;

/**
 * https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/description/
 */
public class MaximumValueOfAnOrderedTripletI {
    public static void main(String[] args) {
        System.out.println(maximumTripletValue(new int[]{12, 6, 1, 2, 7})); // 77
//        System.out.println(maximumTripletValue(new int[]{15, 14, 17, 13, 18, 17, 10, 19, 2, 20, 12, 9}));
    }


    public static long maximumTripletValue(int[] nums) {
        long res = 0, imax = 0, dmax = 0;
        for (int num : nums) {
            res = Math.max(res, dmax * num);
            dmax = Math.max(dmax, imax - num);
            imax = Math.max(imax, num);
        }
        return res;
    }


    public static long maximumTripletValueM(int[] nums) {
        // start from end mind max for k
        // start from beginning find max for i
        // between i and k find min

        int l = 0;
        int r = nums.length - 1;
        int i = l + 1;
        int k = r - 1;

        while (l <= r) {
            if (nums[i] < nums[l]) {
                i = l;
            } else {
                l++;
                continue;
            }

            if (nums[k] < nums[r]) {
                k = r;
            }
            r--;
        }

        int j = i + 1;
        l = i;
        r = k;

        while (l < r) {
            if (nums[j] > nums[l]) {
                j = l;
            }
            l++;
        }

        return (nums[i] - nums[j]) * nums[k];
    }
}
