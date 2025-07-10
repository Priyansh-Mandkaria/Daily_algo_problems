// Last updated: 7/10/2025, 8:57:38 AM
class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, j = 1;
        for (int i = n - 1; i >= 1; i--) {
            if (nums[i] != nums[i - 1]) 
                j++;
            if (j == 3)
                return nums[i - 1];
        }
        if(nums.length < 3){
            return nums[nums.length-1];
        }
        return nums[n - 1];
    }
}