// Last updated: 7/10/2025, 8:57:24 AM
class Solution {
    public int subarraySum(int[] arr, int k) {
        int cnt = 0;
        for(int i = 0 ; i < arr.length; i++){
            int sum = 0;
            for(int j = i ; j < arr.length; j++){
                sum += arr[j];
                if(sum == k){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}