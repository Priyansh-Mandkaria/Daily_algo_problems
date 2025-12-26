// Last updated: 12/26/2025, 11:32:58 AM
1class Solution {
2    public int bestClosingTime(String customers) {
3        int penalty = 0, best_penalty = 0, ans = 0;
4        char[] ch = customers.toCharArray();
5        for(int i = 0; i < customers.length(); i++) {
6            if(ch[i] == 'Y') {
7                penalty--;
8                if(penalty < best_penalty) {
9                    best_penalty = penalty;
10                    ans = i + 1;
11                }
12            }
13            else penalty++;
14        }
15        return ans;
16    }
17}