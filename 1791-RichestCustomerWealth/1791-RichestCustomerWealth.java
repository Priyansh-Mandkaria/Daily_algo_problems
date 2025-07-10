// Last updated: 7/10/2025, 8:54:48 AM
class Solution {
    public int maximumWealth(int[][] accounts) {
        int[] sum = new int[accounts.length];
        for(int i = 0 ; i < accounts.length ; i++){
            for(int j = 0 ; j < accounts[i].length; j++){
                sum[i] += accounts[i][j];
            }
        }
        int max = sum[0];
        for(int i = 0 ; i < sum.length ; i++){
            if ( sum[i] > max){
                max = sum[i];
            }
        }
        return max;
    }
}