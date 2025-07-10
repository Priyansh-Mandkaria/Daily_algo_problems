// Last updated: 7/10/2025, 8:55:09 AM
class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 4) {
            return 0;
        }

        // Sort the array
        Arrays.sort(nums);

        // Calculate minimum difference by considering changing up to three elements
        int minDifference = Integer.MAX_VALUE;
        minDifference = Math.min(minDifference, nums[n-1] - nums[3]); // Change three smallest
        minDifference = Math.min(minDifference, nums[n-2] - nums[2]); // Change two smallest and one largest
        minDifference = Math.min(minDifference, nums[n-3] - nums[1]); // Change one smallest and two largest
        minDifference = Math.min(minDifference, nums[n-4] - nums[0]); // Change three largest
        return minDifference;
    }
}