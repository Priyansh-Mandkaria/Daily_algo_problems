// Last updated: 7/27/2026, 8:08:48 AM
1class Solution {
2    public int maxProduct(int[] nums) {
3        Arrays.sort(nums);
4        return (nums[nums.length-1]-1)*(nums[nums.length-2]-1);
5    }
6}