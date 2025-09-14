// Last updated: 9/14/2025, 11:50:44 AM
class Solution {
    public int countStableSubsequences(int[] nums) {
        int MOD = 1_000_000_007;
        long eoo = 0; 
        long eto = 0; 
        long eoe = 0;
        long ete = 0; 
        for (int num : nums) {
            if (num % 2 != 0) { 
                long nooc = (eoe + ete + 1) % MOD; 
                long ntoc = eoo;                    
                eoo = (eoo + nooc) % MOD;
                eto = (eto + ntoc) % MOD;
            } else { // even
                long noec = (eoo + eto + 1) % MOD; 
                long ntec = eoe;                    
                eoe = (eoe + noec) % MOD;
                ete = (ete + ntec) % MOD;
            }
        }
        long ans = (eoo + eto + eoe + ete) % MOD;
        return (int) ans;
    }
}