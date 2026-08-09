// Last updated: 8/9/2026, 10:06:40 PM
1class Solution {
2    public String maximumOddBinaryNumber(String s) {
3        int cnt1 = 0, cnt0 = 0;
4        for (char a : s.toCharArray()) {
5            if (a == '1') cnt1++;
6            else if (a == '0') cnt0++;
7        }
8        StringBuilder ans = new StringBuilder();
9        ans.append("1".repeat(cnt1 - 1));
10        ans.append("0".repeat(cnt0));
11        ans.append("1");
12        return ans.toString();
13    }
14}
15
16