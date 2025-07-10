// Last updated: 7/10/2025, 8:49:55 AM
class Solution {
    public int maxSum(int[] nums, int k, int m) {
        int n=nums.length;
        int[] pre=new int[n];
        pre[0]=nums[0];
        
        for(int i=1;i<n;i++){
            pre[i] = nums[i]+pre[i-1];
        }
        long[][][] dp=new long[n][k+1][2];
        for(long[][] i:dp){
            for(long[] j:i) Arrays.fill(j,Long.MIN_VALUE);
        }
        return (int)helper(nums, k,m,0,pre,n,dp,0);
    }

    public long helper(int[] nums, int k, int m, int i, int[] pre, int n,long[][][] dp, int check){
        if(i==n && k>0) return Integer.MIN_VALUE;
        if(i==n || k==0) return 0;
        
        if(dp[i][k][check]!=Long.MIN_VALUE) return dp[i][k][check];
        long ans=Integer.MIN_VALUE;
        if(check==0)ans=Math.max(ans, helper(nums, k, m, i+1, pre,n,dp,0));
        long take=Integer.MIN_VALUE;
        take = Math.max(take, nums[i] + helper(nums, k, m,i+1,pre,n,dp,1));
        if(i+m-1<n){
            long next=helper(nums, k-1,m,i+m,pre,n,dp,0);
            if(next!=Integer.MIN_VALUE) take = Math.max(take,next + pre[i+m-1]-((i-1>=0)?pre[i-1]:0));
        }
        ans = Math.max(ans, take);

        dp[i][k][check]=ans;
        return ans;
        
    }
}