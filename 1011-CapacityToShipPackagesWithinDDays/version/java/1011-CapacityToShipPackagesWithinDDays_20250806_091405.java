// Last updated: 8/6/2025, 9:14:05 AM
class Solution {
    public int shipWithinDays(int[] arr, int d) {
        int low = Arrays.stream(arr).max().getAsInt();  
        int high = Arrays.stream(arr).sum();            
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (daysRequired(arr, mid) <= d) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
    static int daysRequired(int[] arr, int capacity) {
        int days = 1, current = 0;
        for (int weight : arr) {
            if (current + weight > capacity) {
                days++;
                current = 0;
            }
            current += weight;
        }
        return days;
    }
}