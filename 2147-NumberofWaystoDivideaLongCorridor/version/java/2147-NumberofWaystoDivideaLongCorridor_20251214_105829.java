// Last updated: 12/14/2025, 10:58:29 AM
1class Solution {
2    int mod = 1000000007;
3    public int numberOfWays(String corridor) {
4        int n = corridor.length(); int cnt = 0;
5        for(int i=0; i<n; i++){
6            if(corridor.charAt(i) == 'S') cnt++;
7        }
8        if(cnt == 0 || cnt % 2 != 0) return 0;
9        cnt = 0;
10        long ans = 1;
11        int i=0; int p = 0; boolean flag = false;
12        while(i < n){
13            if(corridor.charAt(i) == 'S'){
14                cnt++;
15                if(cnt % 2 == 0){
16                    flag = true;
17                } else if(cnt > 2){
18                    ans = (ans * (p + 1)) % mod;
19                    cnt = 1; flag = false;
20                    p = 0;
21                }
22            } else if(flag){
23                p++;
24            }
25            i++;
26        }
27        return (int)ans;
28    }
29}