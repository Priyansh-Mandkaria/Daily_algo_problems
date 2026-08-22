// Last updated: 8/22/2026, 7:21:35 AM
1class Solution {
2    public boolean checkDivisibility(int n) {
3        int cur = n, t = 0;
4        long mul =1;
5        while(cur > 0){
6            int x = cur % 10;
7            if(x == 0) mul = 0;
8            if(mul != 0 ) mul*= x;
9            t += x;
10            cur/=10;
11        }
12        return n %(mul+t) == 0;
13    }
14}