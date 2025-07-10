// Last updated: 7/10/2025, 8:57:09 AM
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n - k + 1]; 
        int[] left = new int[n - k + 1]; 
        int[] right = new int[n - k + 1];
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (i >= k - 1) {
                sum[i - k + 1] = currentSum;
                currentSum -= nums[i - k + 1];
            }
        }
        int best = 0;
        for (int i = 0; i < sum.length; i++) {
            if (sum[i] > sum[best]) {
                best = i;
            }
            left[i] = best;
        }
        best = sum.length - 1;
        for (int i = sum.length - 1; i >= 0; i--) {
            if (sum[i] >= sum[best]) {
                best = i;
            }
            right[i] = best;
        }
        int[] result = new int[3];
        int maxSum = 0;
        for (int mid = k; mid < sum.length - k; mid++) {
            int l = left[mid - k];
            int r = right[mid + k];
            int total = sum[l] + sum[mid] + sum[r];
            if (total > maxSum) {
                maxSum = total;
                result[0] = l;
                result[1] = mid;
                result[2] = r;
            }
        }
        return result;
        // int n = nums.length;
        // int[][] dp = new int[4][n + 1]; 
        // int[][] trace = new int[4][n + 1]; 
        // int[] prefixSum = new int[n + 1];
        // for (int i = 0; i < n; i++) {
        //     prefixSum[i + 1] = prefixSum[i] + nums[i];
        // }
        // for (int t = 1; t <= 3; t++) {
        //     for (int i = k; i <= n; i++) {
        //         int currentSum = prefixSum[i] - prefixSum[i - k];
        //         if (dp[t][i - 1] > dp[t - 1][i - k] + currentSum) {
        //             dp[t][i] = dp[t][i - 1];
        //             trace[t][i] = trace[t][i - 1];
        //         } else {
        //             dp[t][i] = dp[t - 1][i - k] + currentSum;
        //             trace[t][i] = i - k;
        //         }
        //     }
        // }
        // int[] result = new int[3];
        // int idx = n;
        // for (int t = 3; t > 0; t--) {
        //     result[t - 1] = trace[t][idx];
        //     idx = trace[t][idx];
        // }
        // return result;
    }
}