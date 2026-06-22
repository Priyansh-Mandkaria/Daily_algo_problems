// Last updated: 6/22/2026, 1:35:13 PM
class Solution {
    public long minArraySum(int[] n, int k) {
        long sum = Arrays.stream(n).asLongStream().sum();
        HashMap<Integer,Long> map = new HashMap<>();
        map.put(0,0L);
        long p = 0L;
        long q = 0L;
        for(int x : n){
            p += x;
            int r = (int)((p%k+k)%k);
            long a = map.getOrDefault(r,Long.MIN_VALUE/2);
            if(a > Long.MIN_VALUE/2) a+=p;
            long b = Math.max(q,a);
            map.merge(r,b-p,Long::max);
            q = b;
        }
        return sum-q;
    }
}