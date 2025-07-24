// Last updated: 7/24/2025, 7:49:35 PM
class Solution {
    public int search(int[] arr, int target) {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = low + (high- low)/2;
            if( arr[mid] == target) return mid;
            // left part sorted
            if( arr[low] <= arr[mid]){
                if(target >= arr[low] && target < arr[mid]) high = mid - 1;
                else low = mid + 1;
            }
            // right part sorted
            else{
                if(target > arr[mid] && target <= arr[high]) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }
}