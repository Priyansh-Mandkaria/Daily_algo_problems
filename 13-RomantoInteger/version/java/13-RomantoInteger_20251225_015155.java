// Last updated: 12/25/2025, 1:51:55 AM
1class Solution {
2    public int romanToInt(String s) {
3        int res = 0;
4        Map<Character, Integer> roman = new HashMap<>();
5        roman.put('I', 1);
6        roman.put('V', 5);
7        roman.put('X', 10);
8        roman.put('L', 50);
9        roman.put('C', 100);
10        roman.put('D', 500);
11        roman.put('M', 1000);
12        for (int i = 0; i < s.length() - 1; i++) {
13            if (roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
14                res -= roman.get(s.charAt(i));
15            } else {
16                res += roman.get(s.charAt(i));
17            }
18        }
19        return res + roman.get(s.charAt(s.length() - 1));
20    }
21}