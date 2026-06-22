// Last updated: 6/22/2026, 1:33:58 PM
class Solution {

    private static final int[] waves = new int[570];

    static {
        int j = 0;

        for (int i = 0; i < 1000; i++) {
            int r = i % 10;
            int m = (i / 10) % 10;
            int l = (i / 100) % 10;

            if ((m > Math.max(l, r)) || (m < Math.min(l, r))) {
                waves[j++] = i;
            }
        }
    }

    public long totalWaviness(long A, long B) {
        return waveCount(B) - waveCount(A - 1);
    }

    private long waveCount(long num) {
        if (num < 100) return 0;

        long res = 0;

        for (int pattern : waves) {
            res += countWays(num, pattern);
        }

        return res;
    }

    private long countWays(long num, int pattern) {

        long type = pattern < 100 ? 1 : 0;
        long ways = 0;
        long mult = 1;

        for (int i = 0; i < 16; i++) {

            if (mult * 100 > num) break;

            long pre = num / (mult * 1000);
            long cur = (num / mult) % 1000;
            long suf = num % mult;

            long count = 0;
            long edge = 0;

            if (cur > pattern) {

                count = pre - type + 1;

            } else if (cur == pattern) {

                count = Math.max(0L, pre - type);

                if (pre >= type) {
                    edge = suf + 1;
                }

            } else {

                count = Math.max(0L, pre - type);
            }

            ways += count * mult + edge;
            mult *= 10;
        }

        return ways;
    }
}