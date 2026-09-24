// Last updated: 9/24/2026, 9:51:28 AM
1class Solution {
2    public int smallestIndex(int[] nums) {
3        for (int i = 0; i < nums.length; i++) {
4        int n = nums[i];
5            int sum = 0;
6            while (n > 0) {
7                int digit = n % 10;
8                sum = sum + digit;
9                n = n / 10;
10            }
11            if (sum == i) {
12                return i;
13            }
14        }
15        return -1;
16    }
17}