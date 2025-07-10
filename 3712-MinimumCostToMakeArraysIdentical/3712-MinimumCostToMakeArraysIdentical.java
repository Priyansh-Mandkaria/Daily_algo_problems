// Last updated: 7/10/2025, 8:49:58 AM
import java.util.Arrays;

class Solution {
    private long score(int[] a_list, int[] b_list) {
        long res = 0;
        for (int i = 0; i < a_list.length; i++) {
            res += Math.abs((long) a_list[i] - (long) b_list[i]);}
        return res; }

    public long minCost(int[] arr, int[] brr, long k) {
        long originalScore = score(arr, brr);

        int[] sorted_arr = arr.clone();
        int[] sorted_brr = brr.clone();
        Arrays.sort(sorted_arr);
        Arrays.sort(sorted_brr);
        long sortedScore = score(sorted_arr, sorted_brr) + k;

        return Math.min(originalScore, sortedScore);}
}