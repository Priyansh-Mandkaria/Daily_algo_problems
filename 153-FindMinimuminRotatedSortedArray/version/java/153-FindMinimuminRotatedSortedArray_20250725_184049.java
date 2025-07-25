// Last updated: 7/25/2025, 6:40:49 PM
class Solution {
    public int findMin(int[] arr) {
        int low = 0;
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int high = n - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[low] <= arr[high]){
                min = Math.min(min,arr[low]);
                break;
            }
            if(arr[low] <= arr[mid]){
                min = Math.min(min,arr[mid]);
                low = mid + 1;
            }
            else{
                min = Math.min(min,arr[mid]);
                high = mid - 1;
            }
        }
        return min;
    }
}