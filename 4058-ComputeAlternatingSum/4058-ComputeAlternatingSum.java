// Last updated: 6/22/2026, 1:34:05 PM
class Solution {
    public int alternatingSum(int[] nums) {
        int sum = 0 ;
        for(int i = 0 ; i < nums.length; i++){
            if(i % 2 == 0) sum = sum + nums[i];
            else sum = sum - nums[i];
        }
        return sum;
    }
}