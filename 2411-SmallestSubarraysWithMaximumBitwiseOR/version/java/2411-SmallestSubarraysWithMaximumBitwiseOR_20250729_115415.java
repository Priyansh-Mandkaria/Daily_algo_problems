// Last updated: 7/29/2025, 11:54:15 AM
class Solution {
    public int[] smallestSubarrays(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {  
            res[i] = 1;
            for (int j = i - 1; j >= 0 && (arr[j] | arr[i]) != arr[j]; j--){
                arr[j] |= arr[i];
                res[j] = i - j + 1;
            }
        }
        return res;
    }
}