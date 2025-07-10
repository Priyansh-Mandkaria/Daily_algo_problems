// Last updated: 7/10/2025, 8:54:54 AM
class Solution {
    public int numWays(String[] words, String target) {
        int MOD = 1000000007;
        int m = target.length();
        int n = words[0].length();
        long[] dp = new long[m + 1];
        dp[0] = 1;
        int[][] charCount = new int[n][26];
        for (String word : words) {
            for (int i = 0; i < n; i++) {
                charCount[i][word.charAt(i) - 'a']++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                char c = target.charAt(j);
                dp[j + 1] += dp[j] * charCount[i][c - 'a'];
                dp[j + 1] %= MOD;
            }
        }
        return (int) dp[m];
    }
}