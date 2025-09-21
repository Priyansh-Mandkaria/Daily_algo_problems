// Last updated: 9/21/2025, 11:24:50 AM
class Solution {
    public int evenNumberBitwiseORs(int[] nums) {
        int or = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0){
                or = or | nums[i];
            }
        }
        return or;
    }
}