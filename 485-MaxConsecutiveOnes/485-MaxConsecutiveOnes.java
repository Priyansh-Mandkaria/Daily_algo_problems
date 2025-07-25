// Last updated: 7/10/2025, 8:57:30 AM
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] == 1){
                count++;
            }
            else{
                count = 0;
            }
            max = Math.max(count,max);
        }
        return max;
    }
}