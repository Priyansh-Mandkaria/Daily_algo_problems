// Last updated: 7/10/2025, 8:56:41 AM
class Solution {
    public boolean isMonotonic(int[] nums) {
        int i = 0;
        int count = 1;
        int count2 = 1;
        if (nums.length == 1) {
            return true;
        }
        while (i < nums.length - 1 && nums[i] <= nums[i + 1]) {
            count++;
            i++;
        }
        if (count == nums.length) {
            return true;
        }
        i = 0;
        while (i < nums.length - 1 && nums[i] >= nums[i + 1]) {
            count2++;
            i++;
        }
        if (count2 == nums.length) {
            return true;
        }
        return false;
    }
}