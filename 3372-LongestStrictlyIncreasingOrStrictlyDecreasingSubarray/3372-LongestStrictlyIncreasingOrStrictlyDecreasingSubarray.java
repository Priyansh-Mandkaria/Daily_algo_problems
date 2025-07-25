// Last updated: 7/10/2025, 8:51:17 AM
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxLen = 1;
        int incLen = 1; 
        int decLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) { 
                incLen += 1;
                decLen = 1; 
            } else if (nums[i] < nums[i - 1]) { 
                decLen += 1;
                incLen = 1; 
            } else { 
                incLen = 1;
                decLen = 1;
            }
            maxLen = Math.max(maxLen, Math.max(incLen, decLen));
        }
        return maxLen;
    }
}