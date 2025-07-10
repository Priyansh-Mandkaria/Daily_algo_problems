// Last updated: 7/10/2025, 8:49:12 AM
class Solution {
    public List<Integer> findCoins(int[] arr) {
        long[] dp = new long[arr.length + 1];
        dp[0] = 1;
        ArrayList<Integer> paise = new ArrayList<>();
        for(int i =  1; i <= arr.length ;i++){
            long a = arr[i-1];
            if(dp[i] > a) return new ArrayList<>();
            if(dp[i] < a){
                paise.add(i);
                for(int j = i; j <= arr.length; j++){
                    dp[j] += dp[j-i];
                }
                if(dp[i] != a) return new ArrayList<>();
            }
        }
            return paise;
    }
}