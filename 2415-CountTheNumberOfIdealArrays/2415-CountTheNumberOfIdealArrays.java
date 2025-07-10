// Last updated: 7/10/2025, 8:53:11 AM
class Solution {
        public int idealArrays(int n, int maxValue) {
        int m = 0;
        long output = 0;
        while ((1 << m) <= maxValue) m++;
		long[] counts = new long[m + 1], dp1 = new long[maxValue + 1], dp2 = new long[m + 1];
		for (int i = 1; i <= m; i++) {
            long[] next = new long[maxValue + 1];
            for (int j = 1; j <= maxValue; j++)
                if (i == 1) next[j] = 1;
                else {
                    int k = j << 1;
                    while (k <= maxValue) {
                        next[k] = (dp1[j] + next[k]) % 1000000007;
                        k += j;
                    }
                }
            for (int j = 1; j <= maxValue; j++) counts[i] = (counts[i] + next[j]) % 1000000007;
            dp1 = next;
        }
        dp2[1] = 1;
        for (int i = 2; i <= n; i++) for (int j = m; j > 1; j--) dp2[j] = (dp2[j] + dp2[j - 1]) % 1000000007;
        for (int i = 1; i <= m; i++) output = (output + counts[i] * dp2[i]) % 1000000007;
        return (int) output;
    }
}