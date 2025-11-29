// Last updated: 11/29/2025, 2:36:19 PM
1class Solution {
2    public int minOperations(int[] nums, int k) {
3        long sum = 0;
4        for(int x : nums)sum += x;
5        return (int)sum%k;
6    }
7}