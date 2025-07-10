// Last updated: 7/10/2025, 8:53:12 AM
class Solution {
    public int longestSubsequence(String s, int k) {
        int sum = 0;
        int cnt = 0;
        int max = (int) (Math.log(k) / Math.log(2)) + 1;
        for (int i = 0; i < s.length(); i++) {
            char bit = s.charAt(s.length() - 1 - i);
            if (bit == '1') {
                if (i < max && sum + (1 << i) <= k) {
                    sum += 1 << i;
                    cnt++;
                }
            } else {
                cnt++;
            }
        }
        return cnt;
    }
}