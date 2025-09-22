// Last updated: 9/22/2025, 8:38:41 AM
class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int max_val = -1;
        int res = 0;
        for (int val : nums) freq[val]++;
        for (int val : freq) max_val = Math.max(max_val, val);
        for (int val : freq)  if (val == max_val)  res += max_val;
        return res;
    }
};