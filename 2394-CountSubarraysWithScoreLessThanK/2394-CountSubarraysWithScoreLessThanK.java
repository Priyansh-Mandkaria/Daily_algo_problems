// Last updated: 7/10/2025, 8:53:14 AM
class Solution {
    public long countSubarrays(int[] nums, long k) {
        long res = 0, total = 0;
        for(int i = 0, j=0;j<nums.length;j++){
            total += nums[j];
            while(i<=j && total*(j-i+1) >= k){
                total -= nums[i];
                i++;
            }
            res += (j-i+1);
        }
        return res;
    }
}