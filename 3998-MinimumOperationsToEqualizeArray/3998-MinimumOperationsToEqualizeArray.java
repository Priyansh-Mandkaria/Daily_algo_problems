// Last updated: 6/22/2026, 1:34:46 PM
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        boolean b = true;
        for(int i = 1; i < n; i++) {
            if(nums[i] != nums[0]) {
                b = false;
                break;
            }
        }
        if(b) return 0;
        return 1;
    }
}