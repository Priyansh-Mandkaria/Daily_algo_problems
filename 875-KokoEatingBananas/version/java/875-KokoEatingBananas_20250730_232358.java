// Last updated: 7/30/2025, 11:23:58 PM
// Koko Eating Banana with Binary Search most optimized
import java.util.*;

class Solution {
    public int minEatingSpeed(int[] arr, int h) {
        int low = 1; 
        int high = Arrays.stream(arr).max().getAsInt();
        int ans = -1; 

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (koko(arr, mid) <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans; 
    }

    private long koko(int[] arr, int speed) {
        long time = 0;
        for (int bananas : arr) {
            time += (bananas + (long)speed - 1) / speed;
        }
        return time;
    }
}
