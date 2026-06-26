// Last updated: 6/26/2026, 1:11:28 PM
1class Solution {
2    public long countMajoritySubarrays(int[] nums, int target) {
3        int n = nums.length;
4        int pref = n;
5        int[] freq = new int[2 * n + 1];
6        freq[n] = 1;
7        long less = 0;
8        long ans = 0;
9        for (int num : nums) {
10            if (num == target) {
11                less += freq[pref];
12                pref++;
13            } else {
14                pref--;
15                less -= freq[pref];
16            }
17            freq[pref]++;
18            ans += less;
19        }
20        return ans;
21    }
22}