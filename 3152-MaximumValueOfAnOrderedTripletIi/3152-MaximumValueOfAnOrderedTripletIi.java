// Last updated: 7/10/2025, 8:51:47 AM
class Solution {
    public long maximumTripletValue(int[] nums) {
        long r = 0, i = 0, d = 0;
        for (int k = 0; k < nums.length; k++) {
            r = Math.max(r, d * nums[k]);
            d = Math.max(d, i - nums[k]);
            i = Math.max(i, nums[k]);
        }
        return r;
    }
}