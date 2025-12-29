// Last updated: 12/29/2025, 3:45:57 PM
1class Solution {
2    public String longestPalindrome(String s) {
3        //we can use brute force - O(n^3);
4        // dp - if we store already palindrome string - O(n^2);
5        // expand around the center - O(n^2) same as dp but it does not store the string so space is O(1); better than dp.
6        // Manacher's algo - O(n); // high level algo like z,etc.. we will learn at last in hard part of the string ok 
7
8        // using expand around the center 
9        if(s == null || s.length() < 1) return "";
10        int start = 0, end = 0;
11        for(int i = 0 ; i < s.length(); i++){
12            int len1 = expandaroundcenter(s,i,i);
13            int len2 = expandaroundcenter(s,i,i+1);
14            int max = Math.max(len1,len2);
15            if(max > end-start){
16                start = i - (max - 1)/2;
17                end = i + max/2;
18            }
19        }
20        return s.substring(start,end+1);
21
22    }
23    private int expandaroundcenter(String s, int left, int right){
24        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
25            left--;
26            right++;
27        }
28        return right-left-1;
29    }
30}