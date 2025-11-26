// Last updated: 11/26/2025, 6:02:17 PM
1class Solution {
2public:
3    bool checkOnesSegment(string s) {
4        bool ze = false;
5        int n = s.size();
6        for(int i = 0;i<n;i++){
7            if(s[i]=='1'){
8                if(ze)return false;
9            }
10            else{
11                ze = true;
12            }
13        }
14        return true;
15    }
16};