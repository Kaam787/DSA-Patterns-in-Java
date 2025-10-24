// Max Sum Subarray of Size K (Sliding Window)

public class MaxSumSubarray {

    // Function to find the maximum sum of a subarray of size 'k'
    public static int findMaxSumSubarray(int[] arr, int k) {
        // If array is empty or 'k' is greater than the array length, return -1
        if (arr == null || arr.length < k || k <= 0) {
            return -1;
        }

        int maxSum = 0;
        int windowSum = 0;

        // Calculate the sum of the first window of size 'k'
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;

        // Slide the window by one element at a time
        for (int i = k; i < arr.length; i++) {
            // Slide the window: remove the leftmost element and add the new rightmost element
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);  // Update maxSum if we find a new maximum
        }

        return maxSum;
    }

    public static void main(String[] args) {
        // Test the function with an example array and window size
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Max Sum Subarray of Size " + k + ": " + findMaxSumSubarray(arr, k));
    }
}
