// Last updated: 2/5/2026, 11:33:05 AM
1class Solution {
2    public int[] constructTransformedArray(int[] nums) {
3        int n = nums.length;
4        int[] result = new int[n];
5        for(int i = 0; i < n; i++){
6            result[i] = nums[((i+nums[i])% n + n) % n];
7        }
8        return result;
9    }
10}