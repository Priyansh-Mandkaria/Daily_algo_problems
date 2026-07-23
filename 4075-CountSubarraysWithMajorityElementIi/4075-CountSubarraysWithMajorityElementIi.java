// Last updated: 7/23/2026, 8:28:19 AM
class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int pref = n;
        int[] freq = new int[2 * n + 1];
        freq[n] = 1;
        long less = 0;
        long ans = 0;
        for (int num : nums) {
            if (num == target) {
                less += freq[pref];
                pref++;
            } else {
                pref--;
                less -= freq[pref];
            }
            freq[pref]++;
            ans += less;
        }
        return ans;
    }
}