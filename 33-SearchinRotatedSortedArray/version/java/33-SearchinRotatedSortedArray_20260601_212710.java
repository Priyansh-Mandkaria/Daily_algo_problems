// Last updated: 6/1/2026, 9:27:10 PM
1class Solution {
2    public int search(int[] arr, int target) {
3        int n = arr.length;
4        int low = 0;
5        int high = n-1;
6        while(low <= high){
7            int mid = low + (high- low)/2;
8            if( arr[mid] == target) return mid;
9            // left part is sorted
10            if( arr[low] <= arr[mid]){
11                if(target >= arr[low] && target < arr[mid]) high = mid - 1;
12                else low = mid + 1;
13            }
14            // right part is sorted
15            else{
16                if(target > arr[mid] && target <= arr[high]) low = mid + 1;
17                else high = mid - 1;
18            }
19        }
20        return -1;
21    }
22}