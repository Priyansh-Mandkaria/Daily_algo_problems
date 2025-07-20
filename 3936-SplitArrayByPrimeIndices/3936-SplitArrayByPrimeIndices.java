// Last updated: 7/20/2025, 2:39:30 PM
class Solution {
    public long splitArray(int[] arr) {
        int len = arr.length;
        if(len == 0) return 0;
        boolean[] p = new boolean[len];
        Arrays.fill(p,true);
        if(len > 0)p[0] = false;
        if(len > 1)p[1] = false;
        for(int i = 2 ; i * i < len; i++){
            if(p[i] == true){
                for(int j = i * i; j < len; j+=i){
                    p[j] = false;
                }
            }
        }
        long sum = 0, sum_t = 0;
        for(int i = 0; i < len;i++){
            if(p[i]) sum += arr[i];
            else sum_t += arr[i];
        }
        return Math.abs(sum-sum_t);
    }
}