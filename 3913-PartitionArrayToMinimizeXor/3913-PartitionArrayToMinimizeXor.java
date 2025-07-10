// Last updated: 7/10/2025, 8:49:05 AM
class Solution {
    private boolean check(int[] arr, int k , int x){
        int n = arr.length;
        int[] xo = new int[n + 1];
        for (int i = 0; i < n; i++) {
            xo[i + 1] = xo[i] ^ arr[i];
        }
        boolean[][] dp = new boolean[k + 1][n + 1];
        dp[0][0] = true;
        for (int p = 1; p <= k; p++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[p - 1][j]) {
                        int fin = xo[i] ^ xo[j];
                        if (fin <= x) {
                            dp[p][i] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[k][n];
    }
    public int minXor(int[] arr, int k) {
        int low =0 ;
        int high = (1 << 30);
        int ans = high;
        while(low <= high){
            int mid = low + (high - low)/2 ;
            int x = mid;
            if(check(arr,k,x)){
                ans = x;
                high = x - 1;
            }
            else low = x + 1;
        }
    return ans;
    }
}