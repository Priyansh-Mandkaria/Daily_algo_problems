// Last updated: 9/14/2025, 11:49:10 AM
class Solution {
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        boolean [] ans = new boolean [n];
        if(k > nums.length * n) return ans;
        boolean dp [][] = new boolean [n+1][k+1];
        dp[0][0] = true;

        for(int i=1; i<=n; i++) {
            for(int have=0; have <= k; have++) {
                dp[i][have] = dp[i-1][have] | (nums[i-1] <= have ? dp[i-1][have-nums[i-1]] : false);
            }
        }

        for(int i=1; i<=n; i++) {
            int s=0;
            int e=n-1;
            int index = n;
            while(s <= e) {
                int mid = s+(e-s)/2;
                if(nums[mid] > i) {
                    index = mid;
                    e = mid-1;
                } else s = mid+1;
            }
            int can = Math.min(n-index, k/i);
            if(index == 0) {
                ans[i-1] = k % i == 0 && k/i <= can;
                continue;
            }

            for(int rem=0; rem <= can; rem++) {
                ans[i-1] |= dp[index][k-(rem*i)];
            }
        }

        return ans;
    }
}