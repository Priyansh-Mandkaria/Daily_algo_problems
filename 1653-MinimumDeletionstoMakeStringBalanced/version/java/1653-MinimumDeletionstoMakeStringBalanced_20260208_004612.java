// Last updated: 2/8/2026, 12:46:12 AM
1class Solution {
2    public int minimumDeletions(String s) {
3        int b_before_a = 0, deletion = 0;
4        for(char ch : s.toCharArray()) {
5            if(ch == 'b') b_before_a += 1;
6            else if(b_before_a > 0) {
7                b_before_a -= 1;
8                deletion += 1;
9            }
10        }   
11        return deletion;
12    }
13}