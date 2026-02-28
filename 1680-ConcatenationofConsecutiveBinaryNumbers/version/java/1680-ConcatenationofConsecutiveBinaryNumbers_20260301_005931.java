// Last updated: 3/1/2026, 12:59:31 AM
1class Solution {
2  public int concatenatedBinary(int n) {
3    final int MOD = 1_000_000_007;
4    long ans = 0;
5    for (int i = 1; i <= n; ++i)
6      ans = ((ans << numberOfBits(i)) % MOD + i) % MOD;
7    return (int) ans;
8  }
9  private int numberOfBits(int n) {
10    return (int) (Math.log(n) / Math.log(2)) + 1;
11  }
12}