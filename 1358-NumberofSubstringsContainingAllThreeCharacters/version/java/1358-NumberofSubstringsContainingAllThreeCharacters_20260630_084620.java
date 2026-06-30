// Last updated: 6/30/2026, 8:46:20 AM
1class Solution {
2    public int numberOfSubstrings(String s) {
3        int[] freq = new int[3]; 
4        int left = 0, ans = 0;
5        for (int right = 0; right < s.length(); right++) {
6            freq[s.charAt(right) - 'a']++;
7            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
8                ans += s.length() - right;
9                freq[s.charAt(left) - 'a']--;
10                left++;
11            }
12        }
13        return ans;
14    }
15}