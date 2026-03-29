// Last updated: 3/30/2026, 12:20:12 AM
1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3        Map<Character, Integer> map = new HashMap<>();
4        int left = 0;
5        int max = 0;
6        for (int right = 0; right < s.length(); right++) {
7            char ch = s.charAt(right);
8            if (map.containsKey(ch)) {
9                left = Math.max(left, map.get(ch) + 1);
10            }
11            map.put(ch, right);
12            max = Math.max(max, right - left + 1);
13        }
14        return max;
15    }
16}