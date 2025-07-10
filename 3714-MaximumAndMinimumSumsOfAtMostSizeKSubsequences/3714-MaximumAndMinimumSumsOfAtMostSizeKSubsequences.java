// Last updated: 7/10/2025, 8:49:56 AM
class Solution {
    static final int mod = (int) 1e9 + 7;
    static long[] fact;
    static long[] inv;
    
    static void precomputeFactorials(int n) {
        fact = new long[n + 1];
        inv = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % mod;
        }
        inv[n] = power(fact[n], mod - 2, mod);
        for (int i = n - 1; i >= 0; i--) {
            inv[i] = (inv[i + 1] * (i + 1)) % mod;
        }
    }
    
    static long power(long a, long b, int m) {
        long val = 1;
        a = a % m;
        while (b > 0) {
            if ((b & 1) == 1) val = (val * a) % m;
            b = b >> 1;
            a = (a * a) % m;
        }
        return val;
    }
    
    static long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return (fact[n] * inv[r] % mod * inv[n - r]) % mod;
    }
    
    public int minMaxSums(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        precomputeFactorials(n);
        
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long val = 0;
            int a = i;
            int b = n - 1 - i;
            
            for (int j = 0; j < k && j <= a; j++) {
                val = (val + nCr(a, j)) % mod;
            }
            sum = (sum + (val * nums[i]) % mod) % mod;
            
            val = 0;
            for (int j = 0; j < k && j <= b; j++) {
                val = (val + nCr(b, j)) % mod;
            }
            sum = (sum + (val * nums[i]) % mod) % mod;
        }
        
        return (int) sum;
    }
}