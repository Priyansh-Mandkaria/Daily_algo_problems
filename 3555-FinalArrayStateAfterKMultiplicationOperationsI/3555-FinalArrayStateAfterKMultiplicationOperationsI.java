// Last updated: 7/10/2025, 8:50:43 AM
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        while(k > 0){
            int min = 100000000 ;
            int o = 0;
            for(int i = 0; i < nums.length ; i++ ){
                if(nums[i] < min){
                    min = nums[i];
                    o = i;
                }
            }
            nums[o] = nums[o]*multiplier;
            k--;
        }
        return nums;
    }
}