// Last updated: 12/17/2025, 5:15:56 PM
1class Solution {
2    class State {
3        long maxProfit, buyHold, sellHold;
4        State(long p, long b, long s) {
5            maxProfit = p;
6            buyHold = b;
7            sellHold = s;
8        }
9    }
10    
11    public long maximumProfit(int[] prices, int k) {
12        int firstPrice = prices[0];
13        State[] dp = new State[k + 1];
14        for (int idx = 0; idx <= k; idx++) {
15            dp[idx] = new State(0, -firstPrice, firstPrice);
16        }
17        int n = prices.length;
18        
19        for (int day = 1; day < n; day++) {
20            int currPrice = prices[day];
21            for (int trans = k; trans > 0; trans--) {
22                long prevProfit = dp[trans - 1].maxProfit;
23                dp[trans].maxProfit = Math.max(dp[trans].maxProfit, Math.max(dp[trans].buyHold + currPrice, dp[trans].sellHold - currPrice));
24                dp[trans].buyHold = Math.max(dp[trans].buyHold, prevProfit - currPrice);
25                dp[trans].sellHold = Math.max(dp[trans].sellHold, prevProfit + currPrice);
26            }
27        }
28        
29        return dp[k].maxProfit;
30    }
31}