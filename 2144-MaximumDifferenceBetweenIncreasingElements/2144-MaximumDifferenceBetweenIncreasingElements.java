// Last updated: 7/10/2025, 8:53:58 AM
class Solution {
    public int maximumDifference(int[] nums) {
        int max = 0;
        int diff = 0;
        for(int i = 0; i < nums.length - 1 ; i++){
            diff = 0; 
            for(int j = i + 1 ; j < nums.length ; j++){
                if(nums[j] > nums[i]){
                    diff = nums[j] - nums[i];
                    max = Math.max(max,diff);
                }
            }
        }
        if(max <= 0){
            return -1;
        }
        return max;
    }
}