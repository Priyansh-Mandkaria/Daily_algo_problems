// Last updated: 7/10/2025, 8:51:14 AM
class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        for (int i = 0; i < n - 1; i++) {
            prefixSum[i + 1] = prefixSum[i] + 
                (nums[i] % 2 == nums[i + 1] % 2 ? 1 : 0);
        }
        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            result[i] = prefixSum[to] - prefixSum[from] == 0;
        }
        return result;
    }
}