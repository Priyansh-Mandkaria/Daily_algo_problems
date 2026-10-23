// Last updated: 10/23/2026, 8:34:52 AM
1class Solution {
2    public int sortPermutation(int[] nums) {
3        int k = -1;  
4        for (int i = 0; i < nums.length; i++)
5            if (nums[i] != i) {  
6                k &= nums[i];  
7                if (k == 0) return 0;  
8            }
9        return Math.max(k, 0);  
10    }
11}