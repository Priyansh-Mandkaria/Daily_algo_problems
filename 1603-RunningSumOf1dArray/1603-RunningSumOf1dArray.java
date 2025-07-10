// Last updated: 7/10/2025, 8:55:11 AM
class Solution {
    public int[] runningSum(int[] nums) {
        for (int i = 1 ; i < nums.length; i++){
            nums[i] = nums[i] + nums[i-1];
        }
        return nums;
    }
}