// Last updated: 5/2/2026, 5:44:29 AM
1class Solution {
2        public int rotatedDigits(int N) {
3        int[] dp = new int[N + 1];
4        int count = 0;
5        for(int i = 0; i <= N; i++){
6            if(i < 10){
7                if(i == 0 || i == 1 || i == 8) dp[i] = 1;
8                else if(i == 2 || i == 5 || i == 6 || i == 9){
9                    dp[i] = 2;
10                    count++;
11                }
12            } else {
13                int a = dp[i / 10], b = dp[i % 10];
14                if(a == 1 && b == 1) dp[i] = 1;
15                else if(a >= 1 && b >= 1){
16                    dp[i] = 2;
17                    count++;
18                }
19            }
20        }
21        return count;
22    }
23}