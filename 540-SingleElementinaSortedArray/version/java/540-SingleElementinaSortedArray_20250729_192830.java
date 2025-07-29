// Last updated: 7/29/2025, 7:28:30 PM
class Solution {
    public int singleNonDuplicate(int[] arr) {
        // we can do brute force solution.
        // this one is better like xor of all elements. 
        // better -2 is put all in map and boom . return that element which has freq 1
        // int xor = 0;
        // for(int x : arr) xor ^= x;
        // return xor;

        // so we will do this using binary search because o(logn) is more optimal 
        // also given that in question that it has sorted array.

        int n = arr.length;
        int low = 1;
        int high = n - 2;
        int mid = 0;
        if(n == 1) return arr[0];
        if(arr[0] != arr[1] ) return arr[0];
        if(arr[n-1] != arr[n-2]) return arr[n-1];
        while(low <= high ){
            mid = low + (high - low)/2;
            if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]){
                return arr[mid];
            }
            if((mid % 2 == 1 && arr[mid] == arr[mid-1]) || (mid % 2 == 0 && arr[mid] == arr[mid + 1])){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return arr[mid];
    }
}