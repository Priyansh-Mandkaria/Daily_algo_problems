// Last updated: 12/30/2025, 3:41:09 AM
1class Solution {
2    public int beautySum(String s) {
3        // sum of beauty that is karan se priority queue use nahi kar paa rae hai .
4        int ans = 0;
5        int n = s.length();
6        for(int i = 0; i < n; i++){
7            int []freq = new int[26];
8            for(int j = i; j < n; j++){
9                freq[s.charAt(j) - 'a']++;
10                int max = 0; 
11                int min = Integer.MAX_VALUE;
12                for(int k = 0 ; k < 26; k++){
13                    if(freq[k] > 0){
14                        max = Math.max(max,freq[k]);
15                        min = Math.min(min,freq[k]);
16                    }
17                }
18                ans += (max - min);
19            }
20        }
21        return ans;
22    }
23}