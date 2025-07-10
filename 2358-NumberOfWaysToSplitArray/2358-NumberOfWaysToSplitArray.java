// Last updated: 7/10/2025, 8:53:16 AM
class Solution {
    public int waysToSplitArray(int[] nums) {
        long total_sum = 0;
        int split = 0;
        long current_sum = 0;
        for(int i = 0 ; i< nums.length; i++){
            total_sum += nums[i];
        }
        for(int i = 0 ; i < nums.length - 1; i++){
            current_sum += nums[i];
            if( current_sum >= total_sum - current_sum){ 
                split++;
            }
        }
        return split;
    }
}