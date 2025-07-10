// Last updated: 7/10/2025, 8:58:46 AM
class Solution {
    public int maxProfit(int[] arr) {
        // Got TLE --- 200/212
        // int maxPro = 0;
        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = i + 1; j < arr.length; j++) {
        //         if (arr[j] > arr[i]) {
        //             maxPro = Math.max(arr[j] - arr[i], maxPro);
        //         }
        //     }
        // }
        // return maxPro;
        int maxPro = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            minPrice = Math.min(minPrice, arr[i]);
            maxPro = Math.max(maxPro, arr[i] - minPrice);
        }
        return maxPro;
    }
}