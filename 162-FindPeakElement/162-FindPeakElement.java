// Last updated: 7/10/2025, 8:58:35 AM
class Solution {
    public int findPeakElement(int[] nums) {
         int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1; 
            } else {
                high = mid;
            }
        }
        return low;
    }
}