// Last updated: 7/10/2025, 8:50:22 AM
class Solution {
    static final int MOD = 1_000_000_007;
    public int lengthAfterTransformations(String s, int t) {
        int[] cnt = new int[26];
        long res = s.length();
        int z = 25;
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        while (t-- > 0) {
            res = (res + cnt[z]) % MOD;
            cnt[(z + 1) % 26] = (int)((cnt[(z + 1) % 26] + (long)cnt[z]) % MOD);
            z = (z + 25) % 26;
        }
        return (int)res;
    }
}