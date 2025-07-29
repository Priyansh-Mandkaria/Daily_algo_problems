// Last updated: 7/30/2025, 12:18:35 AM
class Solution {
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        if(n == 1) return n - 1;
        if(arr[0] > arr[1]) return 0;
        if(arr[n-1] > arr[n-2]) return n - 1;
        int low = 1;
        int high = n - 2;
        while( low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] > arr[mid +1] && arr[mid] > arr[mid - 1]) return mid;
            if(arr[mid] > arr[mid-1]) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}