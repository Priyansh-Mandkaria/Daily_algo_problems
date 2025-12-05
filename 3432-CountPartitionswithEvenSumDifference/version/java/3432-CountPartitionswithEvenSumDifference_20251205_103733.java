// Last updated: 12/5/2025, 10:37:33 AM
1class Solution {
2    public int countPartitions(int[] nums) {
3        int totalSum = 0;
4        for (int i=0;i<nums.length;i++) {
5            totalSum += nums[i]; 
6        }
7        int leftSum = 0;
8        int count = 0;
9        for (int i = 0; i < nums.length - 1; i++) { 
10            leftSum += nums[i]; 
11            int rightSum = totalSum - leftSum; 
12            if ((leftSum % 2) == (rightSum % 2)) {
13                count++; 
14            }
15        }
16        return count; 
17    }
18}