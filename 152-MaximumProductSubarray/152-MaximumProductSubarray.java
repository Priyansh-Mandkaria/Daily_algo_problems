// Last updated: 7/10/2025, 8:58:38 AM
class Solution {
    public int maxProduct(int[] arr) {
        int pro = 1;
        int cnt = 0 ;
        int max = arr[0];
        for(int i = 0; i < arr.length; i++){
            pro = 1;
            for(int j = i; j < arr.length; j++){
                pro *= arr[j];
                max = Math.max(max,pro);
            }
        }
        return max;
    }
}