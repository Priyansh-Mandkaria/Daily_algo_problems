// Last updated: 7/10/2025, 8:54:51 AM
class Solution {
    public int waysToMakeFair(int[] nums) {
        int esum = 0;  
        int osum = 0;  
        int n=nums.length;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                osum += nums[i];
            } else {
                esum += nums[i];
            }
        }
        int count = 0;
        int prev = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                osum = osum - nums[i] + prev;
            } else {
                esum = esum - nums[i] + prev;
            }
            if (esum == osum) {
                count++;
            }
            prev = nums[i];
        }
        return count;
    }
}