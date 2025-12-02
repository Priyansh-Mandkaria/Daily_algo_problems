// Last updated: 12/2/2025, 10:13:25 AM
1class Solution {
2    public int countTrapezoids(int[][] po) {
3        HashMap<Integer,Integer> y = new HashMap<>();
4        for(int[] p : po) y.put(p[1],y.getOrDefault(p[1],0)+1);
5        ArrayList<Long> arr = new ArrayList<>();
6        for(int i : y.values())if(i > 1) arr.add((long) i*(i-1)/2);
7        if(arr.size() < 2)return 0;
8        long mod = 1_000_000_007, sum = 0, sum_t = 0;
9        for (long x : arr) {x %= mod;
10            sum = (sum + x) % mod;
11            sum_t = (sum_t + x * x % mod) % mod;
12        }
13        long ans = (sum * sum % mod - sum_t + mod) % mod;
14        return (int) (ans * ((mod + 1) / 2) % mod);
15    }
16}