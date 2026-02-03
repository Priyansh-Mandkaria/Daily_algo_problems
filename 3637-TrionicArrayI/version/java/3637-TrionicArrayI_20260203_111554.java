// Last updated: 2/3/2026, 11:15:54 AM
1class Solution {
2    public boolean isTrionic(int[] nums) {
3        int n = nums.length;
4        if (n < 4) return false;
5
6        int state = 0; 
7        for (int i = 0; i < n - 1; i++) {
8            if (state == 0) {
9                if (nums[i] < nums[i + 1]) {
10                    // Increasing
11                } else if (i > 0 && nums[i] > nums[i + 1]) {
12                    state = 1; // Reached peak
13                } else {
14                    return false;
15                }
16            } else if (state == 1) {
17                if (nums[i] > nums[i + 1]) {
18                    // Decreasing
19                } else if (nums[i] < nums[i + 1]) {
20                    state = 2; // Reached valley
21                } else {
22                    return false;
23                }
24            } else if (state == 2) {
25                if (nums[i] < nums[i + 1]) {
26                    // Increasing again
27                } else {
28                    return false;
29                }
30            }
31        }
32        return state == 2;
33    }
34}