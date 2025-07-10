// Last updated: 7/10/2025, 8:58:39 AM
class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1; 
            } else {
                high = mid; 
            }
        }
        return nums[low];
    }
}