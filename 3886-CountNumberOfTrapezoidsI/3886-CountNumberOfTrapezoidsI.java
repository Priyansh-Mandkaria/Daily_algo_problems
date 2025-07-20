// Last updated: 7/20/2025, 2:39:40 PM
class Solution {
    public int countTrapezoids(int[][] po) {
        HashMap<Integer,Integer> y = new HashMap<>();
        for(int[] p : po) y.put(p[1],y.getOrDefault(p[1],0)+1);
        ArrayList<Long> arr = new ArrayList<>();
        for(int i : y.values())if(i > 1) arr.add((long) i*(i-1)/2);
        if(arr.size() < 2)return 0;
        long mod = 1_000_000_007, sum = 0, sum_t = 0;
        for (long x : arr) {x %= mod;
            sum = (sum + x) % mod;
            sum_t = (sum_t + x * x % mod) % mod;
        }
        long ans = (sum * sum % mod - sum_t + mod) % mod;
        return (int) (ans * ((mod + 1) / 2) % mod);
    }
}