// Last updated: 2/12/2026, 12:41:13 PM
1class Solution {
2    public int longestBalanced(String s) {
3        int max = 0;
4        int n = s.length();
5        for(int i = 0; i < n; i++){
6            int freq[] = new int[26]; 
7            for(int j = i; j < n; j++){
8                char ch = s.charAt(j);
9                freq[ch - 'a']++;    
10                if(issamefreq(freq)){
11                    max = Math.max(max, j - i + 1);
12                }
13            }
14        }
15        return max;
16    }
17    public static boolean issamefreq(int arr[]){
18        int value = 0;
19        for(int a : arr){
20            if(a == 0) continue;
21            if(value == 0) 
22                value = a;
23            else if(value != a) 
24                return false;
25        }
26        return true;
27    }
28}