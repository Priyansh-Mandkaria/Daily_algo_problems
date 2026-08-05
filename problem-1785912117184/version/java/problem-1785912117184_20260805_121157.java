// Last updated: 8/5/2026, 12:11:57 PM
1class Solution {
2    public String convertDateToBinary(String date) {
3        String[] s = date.split("-");
4        StringBuilder n = new StringBuilder();
5        for(int i = 0 ; i < s.length; i++){
6            int num = Integer.parseInt(s[i]);
7            n.append(Integer.toBinaryString(num));
8            if (i < s.length - 1) {
9                n.append("-");
10            }
11        }
12        return n.toString();
13    }
14}