// Last updated: 3/7/2026, 3:52:22 PM
1class Solution {
2    public int minFlips(String s) {
3        int n = s.length();
4        String t = s + s;
5        int ans = n;
6        int mis0 = 0;
7        for(int i = 0; i < 2*n; i++){
8            char expected = (i % 2 == 0) ? '0' : '1';
9            if(t.charAt(i) != expected) mis0++;
10            if(i >= n){
11                int left = i - n;
12                char expLeft = (left % 2 == 0) ? '0' : '1';
13                if(t.charAt(left) != expLeft) mis0--;
14            }
15            if(i >= n - 1){
16                int mis1 = n - mis0;
17                ans = Math.min(ans, Math.min(mis0, mis1));
18            }
19        }
20        return ans;
21    }
22}