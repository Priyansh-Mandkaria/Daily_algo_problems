// Last updated: 7/18/2026, 4:38:57 PM
1class Solution {
2    private int GCD(int a, int b) {
3        if (b == 0) {
4            return a;
5        }
6        return GCD(b, a % b);
7    }
8    public int findGCD(int[] nums) {
9        Arrays.sort(nums);
10        return GCD(nums[0], nums[nums.length-1]);
11    }
12}