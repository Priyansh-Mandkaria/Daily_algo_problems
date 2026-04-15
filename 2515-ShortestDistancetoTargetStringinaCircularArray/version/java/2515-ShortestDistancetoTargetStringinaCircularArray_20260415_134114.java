// Last updated: 4/15/2026, 1:41:14 PM
1class Solution {
2    public int closestTarget(String[] words, String target, int startIndex){
3        int n = words.length;
4        int ans = Integer.MAX_VALUE;
5        for (int i = 0; i < n; i++) {
6            if (words[i].equals(target)) {
7                int clockwise = (i - startIndex + n) % n;
8                int anticlockwise = (startIndex - i + n) % n;
9                ans = Math.min(ans, Math.min(clockwise, anticlockwise));
10            }
11        }
12        return ans == Integer.MAX_VALUE ? -1 : ans;
13    }
14}