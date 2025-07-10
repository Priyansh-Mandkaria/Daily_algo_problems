// Last updated: 7/10/2025, 8:51:13 AM
class Solution {
    public boolean isArraySpecial(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (((nums[i] ^ nums[i-1]) & 1) == 0) 
                return false; 
        }
        return true; 
    }
}