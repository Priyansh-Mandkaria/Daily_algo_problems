// Last updated: 7/10/2025, 8:54:18 AM
class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        int totalSubsets = 1 << n; 
        for (int i = 0; i < totalSubsets; i++) {
            int xorTotal = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    xorTotal ^= nums[j];
                }
            }
            totalSum += xorTotal;
        }
        return totalSum;
    }
}