// Last updated: 6/22/2026, 1:38:02 PM
class Solution {
    public int maxValue(int[] nums, int k) {
            int n = nums.length;
            int[] revnums = new int[n];
            int p1 = n-1;
            for(int i=0;i<n;i++) {
                revnums[p1] = nums[i];
                p1--;
            }
            int ma = (int)Math.pow(2,7);
            int[][][] dp = new int[n+1][k+1][ma],
                      dp1 = new int[n+1][k+1][ma];
            dp[0][0][0] = 1;
            for(int i=1;i<n+1;i++){
                for(int j = 0;j<k+1;j++){
                    if(j==0) {
                        dp[i][j][0]=1;continue;
                    }
                    for(int l = 0 ;l < ma ; l++){
                        if(dp[i-1][j-1][l]==1) {
                            dp[i][j][l | nums[i-1]]=1;
                            // System.out.println
                        }
                        if(dp[i-1][j][l] == 1)
                            dp[i][j][l]=1;
                    }
                }
            }
            dp1[0][0][0] = 1;
            for(int i=1;i<n+1;i++){
                for(int j = 0;j<k+1;j++){
                    if(j==0) {
                        dp1[i][j][0]=1;continue;
                    }
                    for(int l = 0 ;l < ma ; l++){
                        if(dp1[i-1][j-1][l]==1) {
                            dp1[i][j][l | revnums[i-1]]=1;
                        }
                        if(dp1[i-1][j][l] == 1)
                            dp1[i][j][l]=1;
                    }
                }
            }
            int ans = 0 ;
            for(int i=0;i<n-k;i++){
                for(int j=0;j<ma;j++){
                    for(int l=0;l<ma;l++){
                        if(dp[i+1][k][j] == 1 && 
                            dp1[n-i-1][k][l] == 1
                        ){
                            ans = Math.max(ans,j ^ l);
                        }
                        
                    }
                }
            }
            return ans;

        }
    }