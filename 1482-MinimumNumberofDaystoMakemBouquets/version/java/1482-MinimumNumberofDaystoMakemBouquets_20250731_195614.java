// Last updated: 7/31/2025, 7:56:14 PM
// Optimized
class Solution {
    public int minDays(int[] arr, int m, int k) {
        if ((long) k * m > arr.length) return -1;
        int ans = -1;
        int low = Arrays.stream(arr).min().getAsInt();
        int high = Arrays.stream(arr).max().getAsInt();
        while(low <= high){
            int mid = low + (high - low)/2;
            if(possible(arr,mid,k,m) == true){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1; 
            }
        }
        return ans;
    }
    private boolean possible(int[] arr, int a , int k , int m){
        int cnt = 0;
        int cnt2 = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= a){
                cnt++;
            }
            else{
                cnt = 0;
            }
            if(cnt==k)
            {
                cnt2++;
                cnt=0;
            }
        }
        if(cnt2 >= m) return true;
        return false;
    }
}