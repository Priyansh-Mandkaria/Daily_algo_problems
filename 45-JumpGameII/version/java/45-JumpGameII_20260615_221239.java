// Last updated: 6/15/2026, 10:12:39 PM
1class Solution {
2    public int jump(int[] nums) {
3        int ans = 0;   
4        int end = 0;   
5        int farthest = 0; 
6        for(int i = 0; i < nums.length - 1; ++i){
7            farthest = Math.max(farthest, i + nums[i]);
8            if(farthest >= nums.length - 1){
9                ++ans;
10                break;
11            }
12            if( i == end ){
13                ++ans; 
14                end = farthest; 
15            }             
16        }
17        return ans;        
18    }
19}