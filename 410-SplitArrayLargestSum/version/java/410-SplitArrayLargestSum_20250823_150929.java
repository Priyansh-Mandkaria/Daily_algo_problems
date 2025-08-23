// Last updated: 8/23/2025, 3:09:29 PM
// Binary Search on Answers :-  min(max) pattern .
class Solution {
    public int splitArray(int[] arr, int k) {
        int ans = -1;
        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();
        while(low <= high){
            int mid = low + (high - low)/2;
            if(find(arr,mid) <= k){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    private int find(int[] arr, int mid ){
        int cnt = 1, sum = 0;
        for(int i = 0; i < arr.length; i++){
            if( sum + arr[i] <= mid ){
                sum += arr[i];
            }
            else{
                cnt++;
                sum = arr[i];
            }
        }
        return cnt;
    }
}