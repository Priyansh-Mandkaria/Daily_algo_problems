// Last updated: 6/22/2026, 1:35:08 PM
class Solution {
    public int xorAfterQueries(int[] arr, int[][] q) {
        int MOD = 1_000_000_007;
        for(int[] qr : q){
            for(int i = qr[0]; i <= qr[1]; i = i + qr[2]){
                arr[i] = (int)(((long)arr[i]*qr[3])%MOD);
            }
        }
        int ans = 0;
        for(int x : arr) ans ^= x;
        return ans;
    }
}