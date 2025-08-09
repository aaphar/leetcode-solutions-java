package sorting.insertion;

public class Main {
    public void insertionSort(int[] arr) {
        // Mutates elements in arr by inserting out of place elements into appropriate
        // index repeatedly until arr is sorted
        for (int i = 1; i < arr.length; i++) {
            int currentIndex = i;
            while (currentIndex > 0 && arr[currentIndex - 1] > arr[currentIndex]) {
                // Swap elements that are out of order
                int temp = arr[currentIndex];
                arr[currentIndex] = arr[currentIndex - 1];
                arr[currentIndex - 1] = temp;
                currentIndex -= 1;
            }
        }
    }
}
