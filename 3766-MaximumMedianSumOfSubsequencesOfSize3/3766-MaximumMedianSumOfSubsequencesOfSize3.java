// Last updated: 7/30/2025, 1:19:01 PM
class Solution {
    public long maximumMedianSum(int[] arr) {
        Arrays.sort(arr);
        long sum = 0;
        int d = arr.length / 3;
        for (int i = d; i < arr.length; i += 2) sum += arr[i];
        return sum;
    }
}