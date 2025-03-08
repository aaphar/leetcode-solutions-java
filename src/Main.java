import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        int[] arr = {4, 7, 8, 9, 1, 5};
//        int low = 0;
//        int high = arr.length - 1;
//
//        quicksort(arr, low, high);
//
//        for (int j : arr) {
//            System.out.println(j);
//        }

//        int a = 48;
//        int b = 18;
//        int d = gcd(a, b);

//        int[] nums = {2, 7, 11, 15};
//        int target = 9;
//        int[] result = twoSum(nums, target);
//
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//        }

        Dog aDog = new Dog("Max");
        Dog oldDog = aDog;
        System.out.println(aDog);
        System.out.println(oldDog);
        // we pass the object to foo
        aDog.foo(aDog);
        System.out.println(aDog);
        System.out.println(oldDog);
        // aDog variable is still pointing to the "Max" dog when foo(...) returns
        System.out.println(aDog.getName().equals("Max")); // true
        System.out.println(aDog.getName().equals("Fifi")); // false
        boolean b = aDog == oldDog;// true
        System.out.println(b);
    }

    public static void foo(Dog d) {
        System.out.println(d.getName().equals("Max")); // true
        System.out.println(d);
        // change d inside of foo() to point to a new Dog instance construct red with name member variable set to "Fifi"
        d = new Dog("Fifi");
        System.out.println(d);
        System.out.println(d.getName().equals("Fifi")); // true
    }


    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }
        throw new RuntimeException();
    }


    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {

            int pi = position(arr, low, high);

            quicksort(arr, low, pi - 1);
            quicksort(arr, pi + 1, high);
        }
    }

    public static int position(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}