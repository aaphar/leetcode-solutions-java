package prefixSumPattern;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/
 */
public class SubarraySumsDivisibleByK {

    public static void main(String[] args) {
        int[] nums = {-1, 2, 9};
        System.out.println(subarraysDivByK(nums, 2));
    }

    public static int subarraysDivByK(int[] nums, int k) {
        int[] remainders = new int[k];
        int count = 0;
        int sum = 0;
        remainders[0] = 1;

        for (int num : nums) {
            sum += num;
            int mod = sum % k;

            if (mod < 0) {
                mod += k;
            }
            count += remainders[mod];
            remainders[mod]++;
        }

        return count;
    }

    public int subarraysDivByKWithHashMap(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(0, 1);

        for (int num : nums) {
            sum += num;
            int mod = sum % k;
            if (mod < 0) {
                mod += k;
            }
            if (map.containsKey(mod)) {
                count += map.get(mod);
            }
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }

        return count;
    }
}
