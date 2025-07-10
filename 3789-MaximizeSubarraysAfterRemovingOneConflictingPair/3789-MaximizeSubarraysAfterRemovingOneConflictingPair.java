// Last updated: 7/10/2025, 8:49:36 AM
class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {

        List<Integer>[] right = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            right[i] = new ArrayList<>();
        }

        for (int[] x : conflictingPairs) {
            right[Math.max(x[0], x[1])].add(Math.min(x[0], x[1]));
        }

        
        long ans = 0;              
        int maxleft = 0;
        int secmaxleft = 0; 
        long[] imp = new long[n + 1]; 
        long add = 0;
        
        for (int r = 1; r <= n; r++) {
            
            for (int l : right[r]) {

                if (l > maxleft) {
                    int temp = maxleft;
                    maxleft = l;
                    secmaxleft = temp;
                } else {
                    secmaxleft = Math.max(secmaxleft, l);
                }
            }

            ans += (long) (r - maxleft);
            imp[maxleft] += (long) (maxleft - secmaxleft);
            add = Math.max(add, imp[maxleft]);
        }

       
        return ans + add;
    }
}