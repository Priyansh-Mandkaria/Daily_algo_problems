// Last updated: 7/10/2025, 8:49:14 AM
class Solution {
    public long minCuttingCost(int n, int m, int k) {
        if (n <= k && m <= k) return 0;
        return Stream.of(n, m)
                .filter(len -> len > k)
                .mapToLong(len -> IntStream.range(1, len)
                        .filter(a -> a <= k && (len - a) <= k)
                        .mapToLong(a -> (long)a * (len - a))
                        .min().orElse(Long.MAX_VALUE))
                .min().orElse(0);
    }
}