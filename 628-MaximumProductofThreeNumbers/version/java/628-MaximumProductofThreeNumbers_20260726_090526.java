// Last updated: 7/26/2026, 9:05:26 AM
1class Solution {
2    public int maximumProduct(int[] nums) {
3        int max1 = Integer.MIN_VALUE;
4        int max2 = Integer.MIN_VALUE;
5        int max3 = Integer.MIN_VALUE;
6        int min1 = Integer.MAX_VALUE;
7        int min2 = Integer.MAX_VALUE;
8        for (int num : nums) {
9            if (num >= max1) {
10                max3 = max2;
11                max2 = max1;
12                max1 = num;
13            } else if (num >= max2) {
14                max3 = max2;
15                max2 = num;
16            } else if (num >= max3) {
17                max3 = num;
18            }
19            if (num <= min1) {
20                min2 = min1;
21                min1 = num;
22            } else if (num <= min2) {
23                min2 = num;
24            }
25        }
26        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
27    }
28}