// Last updated: 7/10/2025, 8:56:15 AM
class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j]= 1 + dp[i - 1][j - 1];
                }
                else dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
            }
        }
        int longcom=dp[n][m];
        StringBuilder sb=new StringBuilder();
        int i=n,j=m;
        while(i>0 && j>0){
            char a=s1.charAt(i-1);
            char b=s2.charAt(j-1);
            if(a==b) {
                sb.append(a);
                i--;
                j--;
            }
            else{
                if(dp[i-1][j]>dp[i][j-1]){
                    sb.append(a);
                    i--;
                }
                else {
                    sb.append(b);
                    j--;
                }
            }

        }
        while(i>0){
            sb.append(s1.charAt(i-1));
            i--;
        }
        while(j>0){
            sb.append(s2.charAt(j-1));
            j--;
        }
        sb.reverse();
        return sb.toString();
    }
}