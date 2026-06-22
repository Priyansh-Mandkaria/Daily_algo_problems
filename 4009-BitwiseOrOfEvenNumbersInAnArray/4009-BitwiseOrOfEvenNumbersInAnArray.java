// Last updated: 6/22/2026, 1:34:36 PM
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