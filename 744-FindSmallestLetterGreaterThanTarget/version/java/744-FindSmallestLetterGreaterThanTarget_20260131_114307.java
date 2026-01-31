// Last updated: 1/31/2026, 11:43:07 AM
1class Solution {
2    public char nextGreatestLetter(char[] letters, char target) {
3        char res = letters[0];
4        boolean flag = false;
5        for(char ch : letters){
6            if(!flag){
7                if(ch > target){
8                    res = ch;
9                    flag = !flag;
10                }
11            } else {
12                if(ch > target && ch < res)res = ch;
13            }
14        }
15        return res;
16    }
17}